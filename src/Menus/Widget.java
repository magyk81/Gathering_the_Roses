package Menus;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.HashSet;

/**
 * Created by Robin Campos on 9/10/2017.
 * Button that does something when it's clicked on.
 */
public class Widget
{
    // TODO: Replace rectangles with images
    private Rectangle rectMain, rectHighlight;
    private Color colorMain, colorHighlight;
    int posX, posY, width, height;

    /**
     * Coordinates for the rectangle.
     */
    Widget(int posX, int posY, int width, int height,
           Color colorMain, Color colorHighlight, String text, Font font)
    {
        rectMain = new Rectangle(posX, posY, width, height);
        rectMain.setFill(colorMain);
        rectHighlight = new Rectangle(posX, posY, width, height);
        rectHighlight.setFill(colorHighlight);
    }

    public HashSet<Rectangle> getRects()
    {
        HashSet<Rectangle> rects = new HashSet<>();
        rects.add(rectMain);
        rects.add(rectHighlight);
        return rects;
    }

    public boolean cursorInside(int x, int y)
    {
        int x2 = posX + width;
        int y2 = posY + height;
        if (x >= posX && y >= posY && x <= x2 && y <= y2)
        {
            return true;
        }
        return false;
    }
}