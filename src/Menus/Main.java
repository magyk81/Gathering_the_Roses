package Menus;

import Abilities.Ability;
import Abilities.AbilityEnum;
import Common.Card;
import Trait.AttributeEnum;
import Util.LanguageEnum;
import Util.Util;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

/**
 * Created by Robin on 10/23/2016.
 * Application meant to run from this file. It's a start-up menu that's used to
 * select language, resolution, etc. (The start-up menu is different from the start menu.)
 */
public class Main extends Application
{
    private final int WIN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private final int WIN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private final float DIM_FACTOR = Math.min(WIN_HEIGHT, WIN_WIDTH) / 216F;
    private final Color STARTUP_COLOR = Color.DARKGRAY;
    private final String SPLASH = Util.getSplash();

    // This root (VBox) is only for the start-up menu. A different "root" will be used
    // for the main game.
    private final VBox root = new VBox();

    // Attempts to read the system language. Can be changed at start-up or in-game.
    public static LanguageEnum language = getSystemLanguage();

    @Override
    public void start(final Stage stage)
    {
        /*GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = g.getScreenDevices();

        for (int i = 0; i < devices.length; i++)
        {
            System.out.println("Width: " + devices[i].getDisplayMode().getWidth());
            System.out.println("Height: " + devices[i].getDisplayMode().getHeight());
            System.out.println("Device ID: " + devices[i].getIDstring());
            System.out.println();
        }*/

        //Window window = stage; window.getGraphicsConfiguration().getDevice();

        for (Screen screen : Screen.getScreens())
        {
            System.out.println("getMinX(): " + screen.getBounds().getMinX());
        }

        /*******************************************************************************/
        final String VERSION = "indev";

        // Scene (and consequently the Stage) are half the width and height of the screen.
        Scene scene = new Scene(root, WIN_WIDTH / 2, WIN_HEIGHT / 2, STARTUP_COLOR);
        stage.setScene(scene);

        stage.setTitle(SPLASH); // Set splash to be the window title.

        // Sets the stage at the center of the screen.
        stage.setX(WIN_WIDTH / 4);
        stage.setY(WIN_HEIGHT / 4);

        // Don't show the stage until it's sized and positioned correctly.
        stage.show();

        // The paths for the various fonts.
        final String FONT_AUGUSTA = "./Resources/Fonts/Augusta/Augusta.ttf";
        final String FONT_FUTHARK = "./Resources/Fonts/Elder_Futhark/Elder.ttf";
        final String FONT_KNIGHT = "./Resources/Fonts/Supernatural_Knight/Supernatural.ttf";
        final String FONT_KAISHO = "./Resources/Fonts/Kaisho/Kaisho.ttf";
        final String FONT_MORPHEUS = "./Resources/Fonts/Morpheus/Morpheus.ttf";

        // Load all the fonts at once.
        Font FONT_MORPHEUS_SMALL = new Font(DIM_FACTOR * 3);
        Font FONT_MORPHEUS_MEDIUM = new Font(DIM_FACTOR * 4);
        Font FONT_AUGUSTA_MEDIUM = new Font(DIM_FACTOR * 4);
        Font FONT_AUGUSTA_LARGE = new Font(DIM_FACTOR * 6);
        Font FONT_KNIGHT_LARGE = new Font(DIM_FACTOR * 6);
        Font FONT_FUTHARK_LARGE = new Font(DIM_FACTOR * 6);
        Font FONT_KAISHO_MEDIUM = new Font(DIM_FACTOR * 4);

        try {
            FONT_KAISHO_MEDIUM = Font.loadFont(new FileInputStream(
                    FONT_KAISHO), DIM_FACTOR * 4);
            FONT_AUGUSTA_MEDIUM = Font.loadFont(new FileInputStream(
                    FONT_AUGUSTA), DIM_FACTOR * 4);
            FONT_AUGUSTA_LARGE = Font.loadFont(new FileInputStream(
                    FONT_AUGUSTA), DIM_FACTOR * 6);
            FONT_MORPHEUS_SMALL = Font.loadFont(new FileInputStream(
                    FONT_MORPHEUS), DIM_FACTOR * 3);
            FONT_MORPHEUS_MEDIUM = Font.loadFont(new FileInputStream(
                    FONT_MORPHEUS), DIM_FACTOR * 4);
            FONT_KNIGHT_LARGE = Font.loadFont(new FileInputStream(
                    FONT_KNIGHT), DIM_FACTOR * 6);
            FONT_FUTHARK_LARGE = Font.loadFont(new FileInputStream(
                    FONT_FUTHARK), DIM_FACTOR * 6);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Set up various widgets for the start-up menu.
        Button startButton = new Button("Start Game"); // Starts the mainGame
        Button quitButton = new Button("Quit"); // Quits the application
        startButton.setMinSize(130, 45);
        quitButton.setMinSize(70, 45);
        startButton.setFont(FONT_MORPHEUS_MEDIUM);
        quitButton.setFont(FONT_MORPHEUS_MEDIUM);

        // Set up drop-down menu (ComboBox) to select resolution.
        ComboBox<Text> resolutionDropDown = new ComboBox<>();
        resolutionDropDown.getItems().addAll(getResolutionsList());
        // The default text that will show up in the drop-down menu.
        Text resolutionHolder = new Text(Integer.toString(WIN_WIDTH)
                + " x " + Integer.toString(WIN_HEIGHT));
        // The text that will label the drop-down menu.
        Text resolutionText = new Text("Resolution:");
        resolutionDropDown.setValue(resolutionHolder);
        resolutionDropDown.setPrefSize(DIM_FACTOR * 28, DIM_FACTOR * 8);

        // Button that resets the resolutionDropDown.
        Button resetResolutionButton = new Button("Reset to your\nscreen resolution");
        resetResolutionButton.setFont(FONT_MORPHEUS_SMALL);
        resetResolutionButton.setTextAlignment(TextAlignment.CENTER);
        resetResolutionButton.setPrefSize(DIM_FACTOR * 28, DIM_FACTOR * 12);

        // Set up drop-down menu (ComboBox) to select language.
        ComboBox<Text> languageDropDown = new ComboBox<>();
        for (LanguageEnum lang : LanguageEnum.values())
        {
            languageDropDown.getItems().add(new Text(lang.toString()));
        }
        // The default text that will show up in the drop-down menu.
        Text languageHolder = new Text(language.toString());
        // The text that will label the drop-down menu.
        Text languageText = new Text("Language:");
        languageDropDown.setValue(languageHolder);
        languageDropDown.setPrefSize(DIM_FACTOR * 28, DIM_FACTOR * 8);
        languageDropDown.setVisibleRowCount(4);

        // Set up title text and spash text. Import special font for both of them.
        Text titleText = new Text("Gathering the Roses - " + VERSION);
        Text splashText = new Text(SPLASH);
        splashText.setTextAlignment(TextAlignment.LEFT);
        titleText.setFont(FONT_KNIGHT_LARGE);
        splashText.setFont(FONT_FUTHARK_LARGE);
        resolutionHolder.setFont(FONT_AUGUSTA_MEDIUM);
        resolutionText.setFont(FONT_AUGUSTA_LARGE);
        // Set the font for every Text in the resolution drop-down menu.
        for (Text item : resolutionDropDown.getItems())
        {
            item.setFont(FONT_AUGUSTA_MEDIUM);
        }
        languageHolder.setFont(FONT_AUGUSTA_MEDIUM);
        languageText.setFont(FONT_AUGUSTA_LARGE);
        // Set the font for every Text in the language drop-down menu.
        for (Text item : languageDropDown.getItems())
        {
            if (!item.getText().equals(LanguageEnum.WAPANESE.toString()))
            {
                item.setFont(FONT_AUGUSTA_MEDIUM);
            }
            else
            {
                // The Augusta font doesn't support Kanji.
                item.setFont(FONT_KAISHO_MEDIUM);
            }
        }

        // Top horizontal box.
        HBox topHBox = new HBox();
        topHBox.setPadding(new Insets (DIM_FACTOR * 4));

        // This VBox is where the resolution and language drop-down menus will be held.
        VBox leftVBox = new VBox();
        leftVBox.setPrefHeight(WIN_HEIGHT / 2); // This size will always be large enough.
        leftVBox.setSpacing(DIM_FACTOR);
        leftVBox.setPadding(new Insets(DIM_FACTOR * 4));

        // This will be kept at the top of leftVBox.
        StackPane leftVBoxStuffing1 = new StackPane();
        leftVBoxStuffing1.setPrefHeight(DIM_FACTOR * 4);
        // This will be kept between the drop-down menus of leftVBox.
        StackPane leftVBoxStuffing2 = new StackPane();
        leftVBoxStuffing2.setPrefHeight(DIM_FACTOR * 8);

        // Bottom horizontal box.
        HBox bottomHBox = new HBox();
        bottomHBox.setPadding(new Insets(DIM_FACTOR * 4));
        bottomHBox.setSpacing(DIM_FACTOR * 4);

        // The splashText goes in futharkPane, which goes in the bottomHBox.
        StackPane futharkPane = new StackPane();
        StackPane bottomHBoxSpacing = new StackPane();
        // To make sure the splashText is against the left side of bottomHBox.
        bottomHBoxSpacing.setPrefWidth(WIN_WIDTH / 2); // This size will always be large enough.

        // Add boxes and panes to the root.
        root.getChildren().addAll(topHBox, leftVBox, bottomHBox);

        // Add widgets to the boxes and panes.
        topHBox.getChildren().add(titleText);
        leftVBox.getChildren().addAll(leftVBoxStuffing1, resolutionText, resolutionDropDown,
                resetResolutionButton, leftVBoxStuffing2, languageText, languageDropDown);
        futharkPane.getChildren().add(splashText);
        bottomHBox.getChildren().addAll(futharkPane, bottomHBoxSpacing, startButton, quitButton);

        // Set up what actions occur when the buttons are pressed.
        resetResolutionButton.setOnAction(event ->
                resolutionDropDown.setValue(resolutionHolder));

        startButton.setOnAction(event -> {
            MainGame mainGame = new MainGame(stage, getResolution(resolutionDropDown.getValue(), true),
                    getResolution(resolutionDropDown.getValue(), false));
            stage.close(); // Closes the window. Will be shown again by MainGame.
            // Group's children should be cleared before starting the mainGame.
            root.getChildren().clear();
            mainGame.start();
        });

        quitButton.setOnAction(event -> {
            // Group's children should be cleared before quitting the application.
            root.getChildren().clear();
            stage.close(); // Closes the window.
            Platform.exit(); // Closes JavaFX.
            System.exit(0); // Finishes process with exit code 0.
        });

        /*-----------------------------------------------*/

        //Match match = new Match();
        //ForTheAge timer = new ForTheAge(match);

        //timer.start();

        /*-----------------------------------------------*/

        //Application.launch(match.getClass(), argv);

        /*-----------------------------------------------*/

        Card testCard = new Card(
                "Dank Magician",
                AttributeEnum.DARK,
                "human wizard",
                "6B",
                new Ability(AbilityEnum.Wither),
                2500,
                2100,
                5);

        System.out.println(testCard);

        /*-----------------------------------------------*/

        // End all threads when the window is closed.
        stage.setOnCloseRequest(event ->
        {
            Platform.exit(); // Closes JavaFX.
            System.exit(0); // Finishes process with exit code 0.
        });
    }

    /**
     * Uses the method "textExists".
     * @return ArrayList of a variety of common screen resolutions
     * plus the user's own screen resolution if it wasn't in this list.
     */
    private ArrayList<Text> getResolutionsList()
    {
        /* It's okay for them to be out of order because the arrayList
           needs to be sorted in the end anyway. */
        ArrayList<Text> arrayList = new ArrayList<>();
        arrayList.add(new Text("1366 x 768"));
        arrayList.add(new Text("1920 x 1080"));
        arrayList.add(new Text("1280 x 800"));
        arrayList.add(new Text("320 x 568"));
        arrayList.add(new Text("1440 x 900"));
        arrayList.add(new Text("1280 x 1024"));
        arrayList.add(new Text("320 x 480"));
        arrayList.add(new Text("1600 x 900"));
        arrayList.add(new Text("768 x 1024"));
        arrayList.add(new Text("1024 x 768"));
        arrayList.add(new Text("1680 x 1050"));
        arrayList.add(new Text("360 x 640"));
        arrayList.add(new Text("1920 x 1200"));
        arrayList.add(new Text("720 x 1280"));
        arrayList.add(new Text("480 x 800"));
        arrayList.add(new Text("1360 x 768"));
        arrayList.add(new Text("1280 x 720"));
        /* Only add user's screen resolution if it's not in arrayList
           already to avoid duplicates. */
        String userResolution = Integer.toString(WIN_WIDTH)
                + " x " + Integer.toString(WIN_HEIGHT);
        if (!textExists(arrayList, userResolution))
        {
            arrayList.add(new Text(userResolution));
        }
        arrayList.sort(new AlphabetizeText()); // Sort the arrayList.

        return arrayList;
    }

    /**
     * @param arrayList - List that is being searched. Must be a list of Text.
     * @param text - String that is being searched in the list.
     * @return true if the string is found in the list, false if not.
     */
    private boolean textExists(ArrayList<Text> arrayList, String text)
    {
        for (Text node : arrayList)
        {
            if (node.getText().equals(text)) return true;
        }
        return false;
    }

    /**
     * Difficult to test detection of the other system languages besides English.
     * @return One of the available languages. Returns English as default.
     */
    private static LanguageEnum getSystemLanguage()
    {
        switch (Locale.getDefault().getLanguage())
        {
            case ("en") : { return LanguageEnum.ENGLISH; }
            case ("es") : { return LanguageEnum.SPANISH; }
            case ("it") : { return LanguageEnum.ITALIAN; }
            case ("fr") : { return LanguageEnum.FRENCH; }
            case ("de") : { return LanguageEnum.GERMAN; }
            case ("ja") : { return LanguageEnum.WAPANESE; }
            default : { return LanguageEnum.ENGLISH; }
        }
    }

    /**
     * Used to alphabetize lists of Text when using the sort() method.
     */
    private class AlphabetizeText implements Comparator<Text>
    {
        @Override
        public int compare(Text o1, Text o2)
        {
            return o1.getText().compareTo(o2.getText());
        }
    }

    /**
     * Reads the resolution Text and converts it to an integer.
     * @param value - The full text from the resolutionDropDown ComboBox.
     *              Expected format is "#### x ####"
     * @param first - True to read the first number, False to read the second.
     * @return Integer of the resolution.
     */
    private int getResolution(Text value, boolean first)
    {
        int sum = 0, i = 0;
        boolean second = false;
        String valueString = value.getText();
        while (i < valueString.length())
        {
            if (first || second)
            {
                sum *= 10;
                sum += Character.getNumericValue(valueString.charAt(i));
                // If reaching the first space.
                if (first && valueString.charAt(i + 1) == ' ') break;
                // If reading the second number, the while-loop will exit on its own.
            }
            else if (valueString.charAt(i) == 'x')
            {
                i++;
                second = true;
            }
            i++;
        }
        return sum;
    }

}
