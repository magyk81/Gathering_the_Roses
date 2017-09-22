package Menus;

import Common.DirectionEnum;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Robin on 9/17/2017.
 */
public class Keyboard implements EventHandler<KeyEvent>
{
    ArrayList<Widget> widgets;

    Keyboard(ArrayList<Widget> widgets)
    {
        this.widgets = widgets;
    }

    @Override
    public void handle(KeyEvent event)
    {
        EventType type = event.getEventType();
        KeyCode code = event.getCode();

        if (type == KeyEvent.KEY_PRESSED)
        {
            if (code == KeyCode.UP) hoverWidgets(DirectionEnum.NORTH);
            else if (code == KeyCode.LEFT) hoverWidgets(DirectionEnum.WEST);
            else if (code == KeyCode.DOWN) hoverWidgets(DirectionEnum.SOUTH);
            else if (code == KeyCode.RIGHT) hoverWidgets(DirectionEnum.EAST);
            else if (code == KeyCode.ENTER) actWidgets();
        }
    }

    void actWidgets()
    {
        for (Widget widget : widgets)
        {
            if (widget.act()) break;
        }
    }

    void hoverWidgets(DirectionEnum direction)
    {
        Widget initialWidget = null;
        for (Widget widget : widgets)
        {
            if (widget.hover(direction)) return;
            if (widget.isInitial()) initialWidget = widget;
        }
        initialWidget.hover(true);
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
