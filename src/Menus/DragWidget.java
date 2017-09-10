package Menus;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A widget that can be dragged and dropped.
 */
public class DragWidget extends Widget
{
    int followX, followY;

    /**
     * Coordinates for the rectangle.
     */
    DragWidget(int posX, int posY, int width, int height,
               Color colorMain, Color colorHighlight, String text, Font font)
    {
        super(posX, posY, width, height, colorMain, colorHighlight, text, font);
        followX = -1;
        followY = -1;
    }

    /**
     * Only needed for Mouse user, not GamePad users.
     * Call this every time the Mouse is moved while being held down.
     */
    public void followCursor(int x, int y)
    {
        posX = x - followX;
        posY = y - followY;
    }

    /**
     * Call this when the Widget is initially clicked on.
     */
    public void startFollowing(int x, int y)
    {
        followX = x - posX;
        followY = y - posY;
    }

    /**
     * Call this when the Mouse is unclicked.
     */
    public void stopFollowing()
    {
        followX = -1;
        followY = -1;
    }
}
