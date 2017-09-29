package Menus;

import Util.DirectionEnum;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * Created by Robin on 9/22/2017.
 */
public class Display
{
    int minX, maxX, minY, maxY, width, height;
    boolean fullscreen;
    Stage stage;
    final Stage label;

    Display(Screen screen, boolean fullscreen)
    {
        Rectangle2D bounds = screen.getBounds();
        minX = (int) bounds.getMinX();
        maxX = (int) bounds.getMaxX();
        minY = (int) bounds.getMinY();
        maxY = (int) bounds.getMaxY();
        width = (int) bounds.getWidth();
        height = (int) bounds.getHeight();

        label = new Stage();
        label.initStyle(StageStyle.TRANSPARENT);
        label.setOpacity(0.5);

        stage = null;
        this.fullscreen = fullscreen;
    }

    void showLabel(boolean show)
    {
        if (show) label.show();
        else label.hide();
    }

    void showStage(boolean show)
    {
        if (show)
        {
            if (stage == null)
            {
                stage = new Stage();
                stage.setOnCloseRequest(event -> stage = null);
            }
            if (fullscreen) stage.setFullScreen(true);
            stage.show();
        }
        else stage.hide();
    }

    int getMaxX() { return maxX; }
    int getMinX() { return minX; }
    int getMaxY() { return maxY; }
    int getMinY() { return minY; }
    int getWidth() { return width; }
    int getHeight() { return height; }
}
