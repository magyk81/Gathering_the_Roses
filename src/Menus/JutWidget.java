package Menus;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Created by Robin on 9/28/2017.
 */
public class JutWidget extends Widget
{
    private Text text;
    private int jutLength, originalLength;
    private boolean isJutting;
    private ArrayList<Shape> shapes;

    /**
     * Coordinates for the rectangle.
     */
    JutWidget(int posX, int posY, int width, int height, int length) {
        super(posX, posY, width, height);
        jutLength = length;
        originalLength = width;

        isJutting = false;

        text = new Text();
        shapes = new ArrayList<>();
        shapes.addAll(getRects());
        shapes.add(text);
    }

    @Override
    ArrayList<Shape> getShapes()
    {
        return shapes;
    }

    @Override
    void setText(String string, Font font)
    {
        text.setText(string);
        text.setFont(font);

        int posX = getPosX(true);
        int posY = (getPosY(true) + getPosY(false)) / 2;

        posX -= text.getLayoutBounds().getWidth() / 2;
        posY += text.getLayoutBounds().getHeight() / 3;
        // The height offset will vary depending on the font.

        text.setX(posX);
        text.setY(posY);
    }

    @Override
    void hover(boolean here)
    {
        super.hover(here);

        if (here) isJutting = true;
        else isJutting = false;
    }

    /**
     * It either increments or decrements how far the Rectangle is jutted.
     */
    @Override
    void passTime()
    {
        int width = getWidth();
        if (isJutting && width < jutLength)
        {
            setSize(++width, getHeight());
        }
        else if (!isJutting && width > originalLength)
        {
            setSize(--width, getHeight());
        }
    }
}
