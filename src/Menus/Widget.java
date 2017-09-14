package Menus;

import Common.DirectionEnum;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

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
    private boolean hovered;
    private int posX, posY, width, height;
    private String text;
    private Font font;
    private Callable<Void> action;

    /**
     * Coordinates for the rectangle.
     */
    Widget(int posX, int posY, int width, int height)
    {
        action = null;
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

    public HashSet<Rectangle> getRects()
    {
        HashSet<Rectangle> rects = new HashSet<>();
        rects.add(rectMain);
        rects.add(rectHover);
        return rects;
    }

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
     * If coordinates are inside, selected set to true.
     * If coordinates are outside, selected set to false.
     */
    public void hover(int x, int y)
    {
        if (!hovered && cursorInside(x, y))
        {
            hovered = true;
            rectMain.setVisible(false);
            rectHover.setVisible(true);
        }
        else if (hovered && !cursorInside(x, y))
        {
            hovered = false;
            rectMain.setVisible(true);
            rectHover.setVisible(false);
        }
    }

    void setText(String text, Font font)
    {
        this.text = text;
        this.font = font;
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

    void act()
    {
        try {
            if (action != null && hovered) action.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}