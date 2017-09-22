package Menus;

import Common.DirectionEnum;
import Common.Match;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by Robin on 6/22/2017.
 * Starts with the main menu.
 */
class MainGame
{
    private Stage stage;
    private final Group root = new Group();
    private final Scene scene;
    private final MultiDisplay multiDisplay;
    private final Mouse mouse;
    private final Keyboard keyboard;
    private final ArrayList<Widget> widgets;

    private int width, height;

    private final Font FONT_EVANESCENT;
    private final Font FONT_EVANESCENT_LARGE;
    private final Font FONT;

    /**
     * Initial things handled here when MainGame is first initialized.
     * @param stage - Passed from Main's start method.
     * win_width and win_height used to determine initial window dimensions.
     * If win_width and win_height are both zero, the window will be fullscreen.
     */
    MainGame(final Stage stage, int win_width, int win_height)
    {
        scene = new Scene(root, win_width, win_height, Color.GRAY);
        widgets = new ArrayList<>();
        mouse = new Mouse(widgets);
        keyboard = new Keyboard(widgets);

        stage.setTitle("You-Gay-Ho!");
        stage.setScene(scene);

        // The stage is kept and handled by MainGame from here on.
        this.stage = stage;
        multiDisplay = new MultiDisplay();

        width = win_width;
        height = win_height;

        if (win_width == 0 && win_height == 0)
        {
            stage.setFullScreen(true);
        }
        else
        {
            // Window is centered and can't be resized.
            stage.setResizable(false);
            stage.setX((Toolkit.getDefaultToolkit().
                    getScreenSize().width - width) / 2);
            stage.setY((Toolkit.getDefaultToolkit().
                    getScreenSize().height - height) / 2);
        }

        // Set up fonts.
        FONT_EVANESCENT = setUpFont("./Resources/Fonts/Evanescent/Evanescent.ttf",
                Math.min(width + (height / 2), height) / 12);
        FONT_EVANESCENT_LARGE = setUpFont("./Resources/Fonts/Evanescent/Evanescent.ttf",
                Math.min(width + (height / 2), height) / 8);
        /* Font size is proportional to either the width or height,
         * depending on which is smaller. The modifier to the width
         * is for when the height is significantly higher than the width. */
        FONT = setUpFont("./Resources/Fonts/Seagram/Seagram.ttf",
                height / 20);
        /* Button height is the limiting factor,
         * and it's proportional only to the scene's/stage's height. */
    }

    /**
     * Called by Main after MainGame is initialized.
     * Begins with setting up the start menu.
     */
    void start()
    {
        goToMainMenu();
        scene.addEventHandler(MouseEvent.ANY, mouse);
        scene.addEventHandler(KeyEvent.ANY, keyboard);
        stage.show();
    }

    void addWidget(Widget widget)
    {
        widgets.add(widget);
        root.getChildren().addAll(widget.getShapes());
    }

    void addWidgets(Widget[] widgets)
    {
        for (Widget widget : widgets)
        {
           addWidget(widget);
        }
    }

    void clearWidgets()
    {
        widgets.clear();
        root.getChildren().clear();
    }

    private Void goToMainMenu()
    {
        System.out.println("Main Menu");

        int space;
        int sideSpace = (int) (height / 2.0F);
        int topSpace = height / 6;
        int betweenSpace = height / 30;
        int buttonWidth = width - (sideSpace * 2);
        int buttonHeight = height / 10;

        Widget buttons[] = new Widget[5];

        buttons[0] = new NormalWidget(sideSpace, topSpace, buttonWidth, buttonHeight);
        space = betweenSpace + buttons[0].getPosY(false);
        buttons[1] = new NormalWidget(sideSpace, space, buttonWidth, buttonHeight);
        space = betweenSpace + buttons[1].getPosY(false);
        buttons[2] = new NormalWidget(sideSpace, space, buttonWidth, buttonHeight);
        space = betweenSpace + buttons[2].getPosY(false);
        buttons[3] = new NormalWidget(sideSpace, space, buttonWidth, buttonHeight);
        space = betweenSpace + buttons[3].getPosY(false);
        buttons[4] = new NormalWidget(sideSpace, space, buttonWidth, buttonHeight);

        buttons[0].setNeighbors(buttons[4], null, buttons[1], null);
        buttons[1].setNeighbors(buttons[0], null, buttons[2], null);
        buttons[2].setNeighbors(buttons[1], null, buttons[3], null);
        buttons[3].setNeighbors(buttons[2], null, buttons[4], null);
        buttons[4].setNeighbors(buttons[3], null, buttons[0], null);
        buttons[0].setInitial();

        buttons[0].setText("Adventure", FONT);
        buttons[1].setText("Versus", FONT);
        buttons[2].setText("Inventory", FONT);
        buttons[3].setText("Options", FONT);
        buttons[4].setText("Quit", FONT);

        buttons[0].setAction(() -> goToCampaignMenu());
        buttons[1].setAction(() -> goToVersusMenu());
        buttons[2].setAction(() -> goToInventoryMenu());
        buttons[3].setAction(() -> goToOptionsMenu());
        buttons[4].setAction(() -> goToQuitMenu());

        clearWidgets();
        addWidgets(buttons);

        return null;
    }

    private void goToMainMenu_()
    {
        Button[] buttons = { new Button("Adventure"), new Button("Versus"),
                new Button("Inventory"), new Button("Options"), new Button("Quit") };
        buttons[0].setOnAction(event -> goToCampaignMenu());
        buttons[1].setOnAction(event -> goToVersusMenu());
        buttons[2].setOnAction(event -> goToInventoryMenu());
        buttons[3].setOnAction(event -> goToOptionsMenu());
        buttons[4].setOnAction(event -> goToQuitMenu());

        Text titleText = new Text("Gathèring\nthç Roses~");
        titleText.setFont(FONT_EVANESCENT_LARGE);
        titleText.setTextAlignment(TextAlignment.CENTER);

        VBox titlePane = new VBox();
        titlePane.getChildren().add(titleText);
        titlePane.setTranslateX((width - titleText.getLayoutBounds().getWidth()) / 2);

        /* Places the buttons in their proper locations. */
        int buttonTopBounds = 0;
        root.getChildren().clear();

        /* The width of the spaces on the sides where there are no buttons.
           Use (width - sideSpace) to get the position of the right-side space. */
        int sideSpace;

        // Space between buttons.
        int betweenButtons = height / 35;
        int buttonHeight = betweenButtons * 3;

        if (width * 2 / 3 > height) sideSpace = (width - height) / 6 * 5;
        else if (width > height) sideSpace = (width - height) / 2 * 3;
        else sideSpace = height / 10;

        for (int i = 0; i < buttons.length; i++)
        {
            int translateY = betweenButtons * 10 + (i * betweenButtons * 5);
            buttons[i].setTranslateX(sideSpace);
            buttons[i].setTranslateY(translateY);
            buttons[i].setPrefSize(width - (sideSpace * 2), buttonHeight);
            buttons[i].setFont(FONT);
            if (i == 0) buttonTopBounds = translateY;
        }

        root.getChildren().addAll(buttons);

        // If the text is too low that it overlaps the buttons, we'll move it up.
        int textBottomBounds = (int) titleText.getLayoutBounds().getHeight();

        // If the bottom of the title is below the top of the first button
        if (textBottomBounds > buttonTopBounds)
            titlePane.setTranslateY(buttonTopBounds - textBottomBounds / 5 * 6);
        // The (/ 5 * 6) modifier is so that there is space between the title and button.

        // arrangeWidgets() clears the root, so titlePane must be added after.
        root.getChildren().add(titlePane);
    }

    private Void goToCampaignMenu()
    {
        System.out.println("Campaign Menu");

        Button[] buttons = { new Button("Go Back") };

        buttons[0].setOnAction(event -> goToMainMenu());

        Text messageText = new Text("Coming Soon!");
        messageText.setFont(FONT_EVANESCENT_LARGE);
        messageText.setTextAlignment(TextAlignment.CENTER);
        VBox messagePane = new VBox();
        messagePane.getChildren().add(messageText);
        messagePane.setTranslateX((width - messageText.getLayoutBounds().getWidth()) / 2);
        messagePane.setTranslateY(0);
        messagePane.setPrefSize(0, 0);

        root.getChildren().clear();

        buttons[0].setPrefSize(width / 1.5F, height / 6);

        buttons[0].setTranslateX((width / 2) - (width / 3));
        buttons[0].setTranslateY(height - height / 6);

        buttons[0].setFont(FONT);

        messagePane.getChildren().add(buttons[0]);

        root.getChildren().addAll(buttons);

        messagePane.setTranslateY(height / 2);

        root.getChildren().add(messagePane);

        return null;
    }

    private Void goToVersusMenu()
    {
        System.out.println("Versus Menu");

        Button[] buttons = { new Button("1 Screen"), new Button("2 Screens") };
        buttons[0].setOnAction(event -> {
            root.getChildren().clear();

            Stage stages[] = new Stage[1];
            stages[0] = stage;

            Match match = new Match(stages, scene, root);
            match.start(width, height);
        });
        // TODO: Make options menu take care of stage stuff.
        buttons[1].setOnAction(event -> {
            root.getChildren().clear();

            Stage stages[] = new Stage[2];
            stages[0] = stage;
            stages[1] = new Stage();

            Match match = new Match(stages, scene, root);
            match.start(width, height);
        });
        setUpMainMenu("\n\n~Setup Menu", FONT_EVANESCENT, buttons); // TODO: Replace with better menu

        return null;
    }

    private Void goToInventoryMenu()
    {
        System.out.println("Inventory Menu");

        Button[] buttons = { new Button("Go Back") };

        buttons[0].setOnAction(event -> goToMainMenu());

        Text messageText = new Text("Coming Soon!");
        messageText.setFont(FONT_EVANESCENT_LARGE);
        messageText.setTextAlignment(TextAlignment.CENTER);
        VBox messagePane = new VBox();
        messagePane.getChildren().add(messageText);
        messagePane.setTranslateX((width - messageText.getLayoutBounds().getWidth()) / 2);
        messagePane.setTranslateY(0);
        messagePane.setPrefSize(0, 0);

        root.getChildren().clear();

        buttons[0].setPrefSize(width / 1.5F, height / 6);

        buttons[0].setTranslateX((width / 2) - (width / 3));
        buttons[0].setTranslateY(height - height / 6);

        buttons[0].setFont(FONT);

        messagePane.getChildren().add(buttons[0]);

        root.getChildren().addAll(buttons);

        messagePane.setTranslateY(height / 2);

        root.getChildren().add(messagePane);

        return null;
    }

    private Void goToOptionsMenu()
    {
        Button[] buttons = { new Button("Language"), new Button("Resolution"),
                new Button("Multi-display/Split-screen") };
        buttons[0].setOnAction(event -> goToLanguageMenu());
        buttons[1].setOnAction(event -> goToResolutionMenu());
        buttons[2].setOnAction(event -> goToSplitScreenMenu());
        setUpMainMenu("\n\n~Options Menu", FONT_EVANESCENT, buttons);

        return null;
    }

    private void goToLanguageMenu()
    {

    }

    private void goToResolutionMenu()
    {

    }

    private void goToSplitScreenMenu()
    {

    }

    private Void goToQuitMenu()
    {
        System.out.println("Quit Menu");

        int space;
        int sideSpace = (int) (height / 2.0F);
        int topSpace = height / 6;
        int betweenSpace = height / 30;
        int buttonWidth = width - (sideSpace * 2);
        int buttonHeight = height / 10;

        Widget buttons[] = new Widget[2];

        buttons[0] = new NormalWidget(sideSpace, topSpace, buttonWidth, buttonHeight);
        space = betweenSpace + buttons[0].getPosY(false);
        buttons[1] = new NormalWidget(sideSpace, space, buttonWidth, buttonHeight);

        buttons[0].setNeighbors(buttons[1], null, buttons[1], null);
        buttons[1].setNeighbors(buttons[0], null, buttons[0], null);
        buttons[0].setInitial();

        buttons[0].setText("Yes", FONT);
        buttons[1].setText("No", FONT);

        buttons[0].setAction(() -> quit());
        buttons[1].setAction(() -> goToMainMenu());

        clearWidgets();
        addWidgets(buttons);

        return null;
    }

    private Void quit()
    {
        clearWidgets();
        root.getChildren().clear();
        stage.close();
        System.exit(0);
        return null;
    }

    /**
     * Sets up a main menu. Do not put more than 5 buttons in the array parameter.
     * Uses the method arrangeWidgets() to clear the root.
     */
    private void setUpMainMenu(String title, Font titleFont, Button[] buttons)
    {
        Text titleText = new Text(title);
        titleText.setFont(titleFont);
        titleText.setTextAlignment(TextAlignment.CENTER);

        VBox titlePane = new VBox();
        titlePane.getChildren().add(titleText);
        titlePane.setTranslateX((width - titleText.getLayoutBounds().getWidth()) / 2);

        /* Places the buttons in their proper locations. */
        int buttonTopBounds = 0;
        root.getChildren().clear();

        /* The width of the spaces on the sides where there are no buttons.
           Use (width - sideSpace) to get the position of the right-side space. */
        int sideSpace;

        // Space between buttons.
        int betweenButtons = height / 35;
        int buttonHeight = betweenButtons * 3;

        if (width * 2 / 3 > height) sideSpace = (width - height) / 6 * 5;
        else if (width > height) sideSpace = (width - height) / 2 * 3;
        else sideSpace = height / 10;

        for (int i = 0; i < buttons.length; i++)
        {
            int translateY = betweenButtons * 10 + (i * betweenButtons * 5);
            buttons[i].setTranslateX(sideSpace);
            buttons[i].setTranslateY(translateY);
            buttons[i].setPrefSize(width - (sideSpace * 2), buttonHeight);
            buttons[i].setFont(FONT);
            if (i == 0) buttonTopBounds = translateY;
        }

        root.getChildren().addAll(buttons);

        // If the text is too low that it overlaps the buttons, we'll move it up.
        int textBottomBounds = (int) titleText.getLayoutBounds().getHeight();

        // If the bottom of the title is below the top of the first button
        if (textBottomBounds > buttonTopBounds)
            titlePane.setTranslateY(buttonTopBounds - textBottomBounds / 5 * 6);
        // The (/ 5 * 6) modifier is so that there is space between the title and button.

        // arrangeWidgets() clears the root, so titlePane must be added after.
        root.getChildren().add(titlePane);
    }

    /**
     * Used only for menus with 5 or less buttons, a title, and nothing else.
     * Places widgets proportional to the scene's/stage's width and height.
     * Will do so using only ints, no floats.
     * Returns the position of the top button.
     */
    /*private int arrangeWidgets(Button[] buttons)
    {

        return topButtonPosition;
    }*/

    /**
     * Size of returned Font proportional to the scene/stage.
     * @param path - String path of the path in Resources.
     * @return Font with proper size adjustment and font resource.
     */
    private Font setUpFont(String path, int size)
    {
        Font FONT;
        try {
            FONT = Font.loadFont(new FileInputStream(
                    path), size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            FONT = null;
        }
        return FONT;
    }
}
