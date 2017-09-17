package Menus;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.HashSet;

import static javafx.scene.input.MouseEvent.MOUSE_DRAGGED;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;

/**
 * Created by Robin on 8/12/2017.
 */
public class Mouse implements EventHandler<MouseEvent>
{
    HashSet<Widget> widgets;

    Mouse()
    {
        widgets = new HashSet<>();
    }

    @Override
    public void handle(MouseEvent event)
    {
        int x = (int) event.getX();
        int y = (int) event.getY();

        EventType type = event.getEventType();
        MouseButton button = event.getButton();

        if (type == MOUSE_DRAGGED)
        {

        }

        else if (button == MouseButton.SECONDARY)
        {

        }
        else if (button == MouseButton.MIDDLE)
        {

        }
        if (button == MouseButton.PRIMARY)
        {
            for (Widget widget : widgets)
            {
                if (widget.act()) break;
            }
        }

        for (Widget widget : widgets)
        {
            widget.hover(x, y);
        }
    }

    void addWidget(Widget widget)
    {
        widgets.add(widget);
    }

    void clearWidgets()
    {
        widgets.clear();
    }
}
