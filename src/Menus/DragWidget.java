package Menus;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

import java.util.ArrayList;

/**
 * A widget that can be dragged and dropped.
 */
public class DragWidget extends Widget
{
    int followX, followY;

    /**
     * Coordinates for the rectangle.
     */
    DragWidget(int posX, int posY, int width, int height)
    {
        super(posX, posY, width, height);
        followX = -1;
        followY = -1;
    }

    @Override
    ArrayList<Shape> getShapes() {
        return null;
    }

    @Override
    void setText(String string, Font font) {

    }

    @Override
    void passTime() {

    }

    /**
     * Only needed for Mouse user, not GamePad users.
     * Call this every time the Mouse is moved while being held down.
     */
    public void followCursor(int x, int y)
    {
        setPos(x - followX, y - followY);
    }

    /**
     * Call this when the Widget is initially clicked on.
     */
    public void startFollowing(int x, int y)
    {
        followX = x - getPosX(true);
        followY = y - getPosY(true);
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
