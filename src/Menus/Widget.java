package Menus;

import Common.DirectionEnum;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Callable;

/**
 * Created by Robin Campos on 9/10/2017.
 * Button that does something when it's clicked on.
 */
public abstract class Widget
{
    // TODO: Replace rectangles with images
    private Rectangle rectMain, rectHover;
    private Color colorMain, colorHover;
    private Widget neighbors[];
    private boolean hovered, initial;
    private int posX, posY, width, height;
    private Callable<Void> action;

    /**
     * Coordinates for the rectangle.
     */
    Widget(int posX, int posY, int width, int height)
    {
        action = null;
        initial = false;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        neighbors = new Widget[4];
        for (int i = 0; i < neighbors.length; i++) neighbors[i] = null;
        rectMain = new Rectangle(posX, posY, width, height);
        /* The color and setFill stuff is just a placeholder for Widget aesthetics.
         * Should eventually be replaced with images. */
        colorMain = Color.RED;
        rectMain.setFill(colorMain);
        rectHover = new Rectangle(posX, posY, width, height);
        colorHover = Color.CYAN;
        rectHover.setFill(colorHover);
        rectHover.setVisible(false);
    }

    HashSet<Rectangle> getRects()
    {
        HashSet<Rectangle> rects = new HashSet<>();
        rects.add(rectMain);
        rects.add(rectHover);
        return rects;
    }

    /**
     * Returns a list of shapes used for adding to the root Group.
     * Uses an ArrayList so that so that they're in a certain order
     * so that the text is in front of the rect, etc.
     */
    abstract ArrayList<Shape> getShapes();

    abstract void setText(String string, Font font);

    /**
     * Only needed for when using the Mouse, not a GamePad.
     */
    public boolean cursorInside(int x, int y)
    {
        int x2 = getPosX(false);
        int y2 = getPosY(false);
        if (x >= posX && y >= posY && x <= x2 && y <= y2)
        {
            return true;
        }
        return false;
    }

    /**
     * Given x and y coordinate of Mouse.
     * If coordinates are inside, hovered set to true.
     * If coordinates are outside, hovered set to false.
     */
    public void hover(int x, int y)
    {
        if (!hovered && cursorInside(x, y)) hover(true);
        else if (hovered && !cursorInside(x, y)) hover(false);
    }

    /**
     * Used by Keyboard or D-pad to select an adjacent widget.
     */
    public boolean hover(DirectionEnum direction)
    {
        Widget neighbor = getNeighbor(direction);
        if (neighbor == null || !hovered) return false;
        neighbor.hover(true);
        hover(false);
        return true;
    }

    void hover(boolean here)
    {
        if (here)
        {
            hovered = true;
            rectMain.setVisible(false);
            rectHover.setVisible(true);
        }
        else
        {
            hovered = false;
            rectMain.setVisible(true);
            rectHover.setVisible(false);
        }
    }

    void setPos(int x, int y)
    {
        posX = x;
        posY = y;
    }

    int getPosX(boolean left)
    {
        if (left) return posX;
        else return posX + width;
    }

    int getPosY(boolean top)
    {
        if (top) return posY;
        else return posY + height;
    }

    void setInitial() { initial = true; }

    boolean isInitial() { return initial; }

    void setAction(Callable<Void> action)
    {
        this.action = action;
    }

    void setNeighbor(Widget widget, DirectionEnum direction)
    {
        switch (direction)
        {
            case NORTH: neighbors[0] = widget;
                        break;
            case EAST:  neighbors[1] = widget;
                        break;
            case SOUTH: neighbors[2] = widget;
                        break;
            case WEST:  neighbors[3] = widget;
                        break;
        }
    }

    void setNeighbors(Widget north, Widget east, Widget south, Widget west)
    {
        neighbors[0] = north;
        neighbors[1] = east;
        neighbors[2] = south;
        neighbors[3] = west;
    }

    Widget getNeighbor(DirectionEnum direction)
    {
        switch (direction)
        {
            case NORTH: return neighbors[0];
            case EAST: return neighbors[1];
            case SOUTH: return neighbors[2];
            case WEST: return neighbors[3];
            default: return this;
        }
    }

    boolean act()
    {
        boolean success = false;
        try {
            if (action != null && hovered)
            {
                action.call();
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}