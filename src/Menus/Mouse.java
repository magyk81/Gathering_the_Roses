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
    MainGame mainGame;
    HashSet<Widget> widgets;

    Mouse(MainGame mainGame)
    {
        this.mainGame = mainGame;
        widgets = new HashSet<>();
    }

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
            for (Widget widget : widgets)
            {
                widget.act();
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
