package Common;

import Abilities.Ability;
import Abilities.AbilityEnum;
import Trait.AttributeEnum;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Robin on 11/11/2016.
 */
public class Match
{
    private final Group root;
    private final Board board;

    private ArrayList<Player> players;
    private static HashSet<UserView> userViews;

    private Rectangle rectSelect;

    public Match(final Stage stage[], Scene scene, Group root)
    {
        //Scene scene = new Scene(root, WIN_WIDTH, WIN_HEIGHT, Color.DARKGRAY);
        this.root = root;
        board = new Board(root);

        stage[0].setScene(scene); // First stage in the array belongs to the host.

        for (int i = 0; i < stage.length; i++)
        {
            stage[i].setTitle("You-Gay-Ho!");
            stage[i].show();
        }

        Mouse mouse = new Mouse();
        Keyboard keyboard = new Keyboard();

        players = new ArrayList<>();
        userViews = new HashSet<>();
        players.add(new Player("Tom"));
        for (Player player : players) // TODO: Do this after controls are decided.
        {
            UserView userView = new UserView(root);
            player.start(userView, board); // TODO: Use only one UserView for sandbox mode
            keyboard.assignUserView(userView);
            mouse.assignUserView(userView);
            userViews.add(userView);
        }

        scene.addEventHandler(MouseEvent.ANY, mouse);
        scene.addEventHandler(KeyEvent.ANY, keyboard);
        mouse.assignMatch(this);

        rectSelect = new Rectangle(0.0, 0.0, new Color(0.6, 0.8, 0.9, 0.5));
    }

    public void start(int stageWidth, int stageHeight)
    {
        //board.setUpInitialLand(players.size(), stageWidth, stageHeight);
        board.setUpInitialLand(2, stageWidth, stageHeight); // for testing

        board.start();

        players.get(0).test();
    }

    static public HashSet<UserView> getUserViews()
    {
        return userViews;
    }

    /**
     * TODO: Move these methods to the Player class
     */

    /* Set to true when making a trail */
    private boolean makingTrail = false;

    /*public void spawnLand(int x, int y)
    {
        board.spawnLand(x - (x % board.getTileSize()), y - (y % board.getTileSize()), 2);
    }*/

    public void startTrail(int x, int y)
    {
        board.spawnTrail(x, y, false);
        makingTrail = true;
    }
    public void continueTrail(int x, int y)
    {
        if (makingTrail) board.spawnTrail(x, y, false);
    }
    public void finishTrail(int x, int y)
    {
        board.spawnTrail(x, y, true);
        makingTrail = false;
    }
}
