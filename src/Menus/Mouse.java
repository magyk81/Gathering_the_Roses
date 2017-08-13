package Menus;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import static javafx.scene.input.MouseEvent.MOUSE_DRAGGED;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;

/**
 * Created by Robin on 8/12/2017.
 */
public class Mouse implements EventHandler<MouseEvent>
{
    @Override
    public void handle(MouseEvent event)
    {
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (event.getEventType() == MOUSE_DRAGGED)
        {

        }

        if (event.getButton() == MouseButton.SECONDARY)
        {

        }
        if (event.getButton() == MouseButton.MIDDLE)
        {

        }
        if (event.getButton() == MouseButton.PRIMARY)
        {

        }
    }
}
