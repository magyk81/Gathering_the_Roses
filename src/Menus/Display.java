package Menus;

import Util.DirectionEnum;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by Robin on 9/22/2017.
 */
public class Display
{
    int minX, maxX, minY, maxY, width, height;
    boolean fullscreen;
    Stage stage;
    Display[] neighbors;

    Display(Screen screen, boolean fullscreen)
    {
        Rectangle2D bounds = screen.getBounds();
        minX = (int) bounds.getMinX();
        maxX = (int) bounds.getMaxX();
        minY = (int) bounds.getMinY();
        maxY = (int) bounds.getMaxY();
        width = (int) bounds.getWidth();
        height = (int) bounds.getHeight();

        stage = new Stage();
        this.fullscreen = fullscreen;
        stage.setOpacity(0.5);
        if (fullscreen) stage.setFullScreen(true);

        neighbors = new Display[8];
    }

    Display getNeighbor(DirectionEnum direction)
    {
        switch (direction)
        {
            case NORTH: return neighbors[0];
            case EAST: return neighbors[1];
            case SOUTH: return neighbors[2];
            case WEST: return neighbors[3];
            default: return this;
        }
    }

    void setNeighbors(Display north, Display east, Display south, Display west)
    {
        neighbors[0] = north;
        neighbors[1] = east;
        neighbors[2] = south;
        neighbors[3] = west;
    }
}
