package Menus;

import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

import java.util.ArrayList;

/**
 * Created by Robin on 8/12/2017.
 * Just a file to organize the player's multi-display and split-screen options
 */
public class MultiDisplay
{
    private int MAX_SCREEN_SIZE = 10000;

    private int numberOfScreensUsed;

    private ArrayList<MyScreen> myScreens;

    MultiDisplay()
    {
        myScreens = new ArrayList<>();

        detectScreens();
    }

    public int getNumberOfScreens(boolean used)
    {
        if (used)
        {
            int total = 0;
            for (MyScreen myScreen : myScreens)
            {
                if (myScreen.isBeingUsed()) total++;
            }
            return total;
        }
        else return myScreens.size();
    }

    public void detectScreens()
    {
        myScreens.clear();

        int givenID = 0;
        for (Screen screen : Screen.getScreens())
        {
            myScreens.add(new MyScreen(screen, givenID));
            givenID++;
        }

        for (MyScreen myScreen : myScreens)
        {
            int closestUp = MAX_SCREEN_SIZE;
            int closestDown = MAX_SCREEN_SIZE;
            int closestLeft = MAX_SCREEN_SIZE;
            int closestRight = MAX_SCREEN_SIZE;

            for (MyScreen otherScreen : myScreens) // TODO: "distance > 0" may need to be changed to "distance >= 0"
            { // TODO: X and Y coordinates may go in different directions. Test this.
                int distanceLeft = myScreen.getMinX() - otherScreen.getMaxX();
                if (distanceLeft < closestLeft && distanceLeft > 0)
                {
                    closestLeft = distanceLeft;
                    myScreen.setLeft(otherScreen);
                }
                int distanceRight =  otherScreen.getMinX() - myScreen.getMaxX();
                if (distanceRight < closestRight && distanceRight > 0)
                {
                    closestRight = distanceRight;
                    myScreen.setRight(otherScreen);
                }
                int distanceUp = myScreen.getMinY() - otherScreen.getMaxY();
                if (distanceUp < closestUp && distanceUp > 0)
                {
                    closestUp = distanceUp;
                    myScreen.setUp(otherScreen);
                }
                int distanceDown =  otherScreen.getMinY() - myScreen.getMaxY();
                if (distanceDown < closestDown && distanceDown > 0)
                {
                    closestDown = distanceDown;
                    myScreen.setDown(otherScreen);
                }
                if (myScreen.getMinX() == 0 && myScreen.getMinY() == 0)
                {
                    myScreen.setMain();
                }
            }
        }
    }

    public void setIconSize(int width, int height)
    {
        int size = Math.min(width, height);

    }

    class MyScreen
    {
        private boolean mainScreen;
        private int ID;
        private MyScreen up, down, left, right;
        private Screen screen;
        private boolean beingUsed;
        private Rectangle icon;

        MyScreen(Screen screen, int ID)
        {
            this.screen = screen;
            this.ID = ID;
            mainScreen = false;
            beingUsed = false;
            icon = new Rectangle();
        }

        Screen getScreen() { return screen; }

        boolean isBeingUsed() { return beingUsed; }

        int getMinX() { return (int) screen.getBounds().getMinX(); }

        int getMinY() { return (int) screen.getBounds().getMinY(); }

        int getMaxX() { return (int) screen.getBounds().getMaxX(); }

        int getMaxY() { return (int) screen.getBounds().getMaxY(); }

        void setLeft(MyScreen myScreen) { left = myScreen; }

        void setRight(MyScreen myScreen) { right = myScreen; }

        void setUp(MyScreen myScreen) { up = myScreen; }

        void setDown(MyScreen myScreen) { down = myScreen; }

        void setMain() { mainScreen = true; }
    }
}
