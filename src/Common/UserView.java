package Common;

import Util.DirectionEnum;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Robin on 7/6/2017.
 * The UserView is manipulated by the board and match.
 * Each participating user has one UserView.
 */
public class UserView
{
    private Group root;

    private Land cornerLand;

    private int stageWidth;
    private int stageHeight;

    private int zoom;
    private int tileDisplayWidth;
    private int boardLength;

    private Rectangle rectSelect;

    UserView(Group root)
    {
        this.root = root;

        zoom = 1;

        // TODO: Make rectSelect have custom color.
        rectSelect = new Rectangle(0.0, 0.0, new Color(0.6, 0.8, 0.9, 0.5));
    }

    /**
     * Called by the board at the beginning.
     * Also sets zoom to 1 and calls updateTileSize.
     * @param cornerLand - The starting cornerland.
     */
    public void assignCornerland(Land cornerLand)
    {
        this.cornerLand = cornerLand;

        // This is the first time tileDisplayWidth is assigned.
        updateTileSize(); // Tile size needs to be updated before updating land display.
    }

    public void assignStageDimensions(int width, int height)
    {
        stageWidth = width;
        stageHeight = height;
    }

    /**
     * Called by the board whenever something changes or moves around.
     */
    public void updatePositioning()
    {
        pan(DirectionEnum.NONE);
    }

    /**
     * Called by Match to move around the map.
     * @param direction - NOTHING to update
     */
    public void pan(DirectionEnum direction)
    {
        cornerLand = cornerLand.getNeighbor(direction);
        Land i = cornerLand;
        int x = 0;
        do {

            Land j = i;
            int y = 0;

            do {
                j.repositionDisplay(root, tileDisplayWidth, zoom, x, y);
                y++;
                j = j.getNeighbor(DirectionEnum.SOUTH);
            } while (!j.equals(i));

            x++;
            i = i.getNeighbor(DirectionEnum.EAST);

        } while (!i.equals(cornerLand));
    }

    /**
     * Called by the board whenever the length changes.
     * @param length - width or height of the board in Lands.
     */
    public void setBoardLength(int length) { boardLength = length; }

    public void zoom(boolean in)
    {
        if (in && zoom > 1) zoom--;
        else if (!in) zoom++;
        updateTileSize(); // Tile size needs to be updated before updating land display.
        pan(DirectionEnum.NONE);
        System.out.println("zoom: " + zoom);
    }

    /**
     * TODO: Eventually make it return highlighted land. For testing, will return cornerland.
     * @return - The land that is currently being highlighted
     */
    public Land getHighlightedLand()
    {
        return cornerLand;
    }

    /*public HashSet<Permanent> getPermanentsInParams(int x1, int x2, int y1, int y2)
    {
        HashSet<Permanent> list = new HashSet<>();
        for (Permanent perm : permanents)
        {
            if (perm.getX() < Math.min(x1, x2)) continue;
            else if (perm.getX() > Math.max(x1, x2)) continue;
            else if (perm.getY() < Math.min(y1, y2)) continue;
            else if (perm.getY() > Math.max(y1, y2)) continue;
            list.add(perm);
        }
        return list;
    }*/

    /**
     * Called by the Land constructor to store tile rectangles here.
     * @param rect - Represents a tile from the Land that's calling this method.
     */
    public void addLandRect(Rectangle rect)
    {
        root.getChildren().add(rect);
    }

    /* Set to true when making a rectangle selection */
    private boolean makingSelection = false;
    private int xSelect, ySelect;
    public void startSelecting(int x, int y)
    {
        xSelect = x;
        ySelect = y;
        rectSelect.setX(x);
        rectSelect.setY(y);
        root.getChildren().add(rectSelect);
        makingSelection = true;
    }
    public void continueSelecting(int x, int y)
    {
        if (makingSelection)
        {
            if (x > xSelect)
            {
                rectSelect.setWidth(x - xSelect);
                rectSelect.setX(xSelect);
            }
            else
            {
                rectSelect.setWidth(xSelect - x);
                rectSelect.setX(x);
            }
            if (y > ySelect)
            {
                rectSelect.setHeight(y - ySelect);
                rectSelect.setY(ySelect);
            }
            else
            {
                rectSelect.setHeight(ySelect - y);
                rectSelect.setY(y);
            }
        }
    }
    public void finishSelecting(int x, int y)
    {
        makingSelection = false;
        selectPieces(x, xSelect, y, ySelect);
        rectSelect.setWidth(0);
        rectSelect.setWidth(0);
        rectSelect.setX(0);
        rectSelect.setY(0);
        root.getChildren().remove(rectSelect);
    }

    public void selectPieces(int x1, int x2, int y1, int y2)
    {
        //players.get(0).selectPermanents(board.getPermanentsInParams(x1, x2, y1, y2));
    }

    private void updateTileSize()
    {
        tileDisplayWidth =
                Math.max(stageWidth, stageHeight) / boardLength / Land.WIDTH / zoom;
    }
}
