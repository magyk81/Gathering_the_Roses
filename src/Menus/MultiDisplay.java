package Menus;

import javafx.stage.Screen;

/**
 * Created by Robin on 8/12/2017.
 * Just a file to organize the player's multi-display and split-screen options
 */
public class MultiDisplay
{
    private int numberOfScreens;
    private int numberOfScreensUsed;

    MultiDisplay()
    {
        for (Screen screen : Screen.getScreens())
        {
            System.out.println("getMinX(): " + screen.getBounds().getMinX());
        }
    }

    public void detectScreens()
    {
        for (Screen screen : Screen.getScreens())
        {

        }
    }

    class myScreen
    {
        private int ID;
    }
}
