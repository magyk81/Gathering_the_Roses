package Menus;

import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

class NormalWidget extends Widget
{
    private Text text;
    private ArrayList<Shape> shapes;

    /**
     * Coordinates for the rectangle.
     */
    NormalWidget(int posX, int posY, int width, int height)
    {
        super(posX, posY, width, height);

        text = new Text();
        shapes = new ArrayList<>();
        shapes.addAll(getRects());
        shapes.add(text);
    }

    /**
     * Sets the text in the center of the widget.
     */
    void setText(String string, Font font)
    {
        text.setText(string);
        text.setFont(font);

        int posX = (getPosX(true) + getPosX(false)) / 2;
        int posY = (getPosY(true) + getPosY(false)) / 2;

        posX -= text.getLayoutBounds().getWidth() / 2;
        posY += text.getLayoutBounds().getHeight() / 3;
        // The height offset will vary depending on the font.

        text.setX(posX);
        text.setY(posY);
    }

    @Override
    void passTime() {

    }

    ArrayList<Shape> getShapes()
    {
        return shapes;
    }
}
