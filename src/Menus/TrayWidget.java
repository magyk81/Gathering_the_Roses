package Menus;

import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

import java.util.ArrayList;

/**
 * Created by Robin on 9/28/2017.
 */
public class TrayWidget extends Widget
{
    /**
     * Coordinates for the rectangle.
     */
    TrayWidget(int posX, int posY, int width, int height)
    {
        super(posX, posY, width, height);
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
}
