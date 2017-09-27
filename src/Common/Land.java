package Common;

import Trait.LandTypeEnum;
import Util.DirectionEnum;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;

/**
 * Due to the nature of how Rectangles are moved by the Land class, they'll be kept here instead of UserView.
 * Created by Robin on 6/28/2017.
 */
public class Land extends Permanent
{
    public final static int WIDTH = 10;

    private boolean neutral = true;
    private LandTypeEnum landType;

    private DirectionEnum[][] tiles;
    // Each rectangle represents one of the tiles.
    private HashSet<Rectangle[][]> rects;

    private HashSet<Permanent> permanents;

    // 0 - North, 1 - West, 2 - South, 3 - East
    private Land neighbors[];

    Land (LandTypeEnum landType)
    {
        neighbors = new Land[4];

        this.landType = landType;

        tiles = new DirectionEnum[WIDTH][WIDTH];
        rects = new HashSet<>();

        for (UserView userView : Match.getUserViews())
        {
            Rectangle[][] rectArray = new Rectangle[WIDTH][WIDTH];
            rects.add(rectArray);

            for (int i = 0; i < WIDTH; i++)
            {
                for (int j = 0; j < WIDTH; j++)
                {
                    //root.getChildren().add(rectArray[i][j]);
                    rectArray[i][j] = new Rectangle();
                    userView.addLandRect(rectArray[i][j]);
                    if (i == 0 || j == 0 || i == WIDTH - 1 || j == WIDTH - 1)
                    {
                        rectArray[i][j].setFill(Color.BLACK);
                    }
                    else rectArray[i][j].setFill(landType.getColor());
                }
            }
        }
        //rects = new Rectangle[WIDTH][WIDTH];

        permanents = new HashSet<>();

        for (int i = 0 ; i < WIDTH ; i++)
        {
            for (int j = 0 ; j < WIDTH ; j++)
            {
                tiles[i][j] = DirectionEnum.NONE;
                //rects[i][j] = new Rectangle();
            }
        }
    }

    Land () { this(LandTypeEnum.NORMAL); }

    Land (Card card)
    {
        this(card.getLandType());
    }

    Land (Land predecessor, LandTypeEnum basicLand)
    {
        this(basicLand);
        neutral = false;
        greetNeighbors(predecessor.getNeighbors());
    }

    Land (Land predecessor, Card card)
    {
        this(predecessor, card.getLandType());
    }

    public void greetNeighbors(Land[] newNeighbors)
    {
        greetNeighbors(newNeighbors[0], newNeighbors[1], newNeighbors[2], newNeighbors[3]);
    }

    public void greetNeighbors(Land north, Land west, Land south, Land east)
    {
        if (!neutral) return;
        neighbors[0] = north; neighbors[1] = west; neighbors[2] = south; neighbors[3] = east;
        north.setNeighbor(this, DirectionEnum.SOUTH);
        west.setNeighbor(this, DirectionEnum.EAST);
        south.setNeighbor(this, DirectionEnum.NORTH);
        east.setNeighbor(this, DirectionEnum.WEST);
    }

    public Land[] getNeighbors()
    {
        return neighbors;
    }

    public Land getNeighbor(DirectionEnum direction)
    {
        if (direction == DirectionEnum.NORTH) return neighbors[0];
        if (direction == DirectionEnum.WEST) return neighbors[1];
        if (direction == DirectionEnum.SOUTH) return neighbors[2];
        if (direction == DirectionEnum.EAST) return neighbors[3];
        return this;
    }

    public void setNeighbor(Land newNeighbor, DirectionEnum direction)
    {
        if (direction == DirectionEnum.NORTH) neighbors[0] = newNeighbor;
        if (direction == DirectionEnum.WEST) neighbors[1] = newNeighbor;
        if (direction == DirectionEnum.SOUTH) neighbors[2] = newNeighbor;
        if (direction == DirectionEnum.EAST) neighbors[3] = newNeighbor;
    }

    public void addPermanent(Permanent permanent)
    {
        permanents.add(permanent);
        for (Land neighbor : neighbors)
        {
            neighbor.removePermanent(permanent);
        }
    }

    public void removePermanent(Permanent permanent)
    {
        permanents.remove(permanent);
    }

    public int getWidth() { return WIDTH; }

    public boolean isNeutral() { return neutral; }

    /**
     * Called every tick after permanents have acted,
     * or every time the camera is changed.
     */
    public void updatePermanentDisplay(int zoom)
    {
        for (Permanent permanent : permanents)
        {
            Rectangle piece = permanent.getPiece();
            piece.setWidth(permanent.getPieceSize(zoom));
            piece.setHeight(permanent.getPieceSize(zoom));
            piece.setX(getX() + permanent.getPieceX(zoom));
            piece.setY(getY() + permanent.getPieceY(zoom));
        }
    }

    /**
     * This method is too heavy to be called every tick.
     * TODO: Only call it when the map is being panned or zoomed.
     * @param root - Needs access to the root.
     * @param tileSize - How large the tiles should be.
     * @param x - How many lands right from the corner land.
     * @param y - How many lands down from the corner land.
     */
    public void repositionDisplay(Group root, int tileSize, int zoom, int x, int y)
    {
        for (Rectangle[][] rectArray : rects)
        {
            if (root.getChildren().contains(rectArray[0][0]))
            {
                for (int i = 0; i < WIDTH; i++)
                {
                    for (int j = 0; j < WIDTH; j++)
                    {
                        rectArray[i][j].setWidth(tileSize);
                        rectArray[i][j].setHeight(tileSize);
                        rectArray[i][j].setX((x * WIDTH * tileSize) + (i * tileSize));
                        rectArray[i][j].setY((y * WIDTH * tileSize) + (j * tileSize));
                    }
                }
                setX(x * WIDTH * tileSize);
                setY(y * WIDTH * tileSize);

                return;
            }
        }

        //else
        {
            System.out.println("Error: repositionDisplay error.");
            /*for (int i = 0; i < WIDTH; i++)
            {
                for (int j = 0; j < WIDTH; j++)
                {
                    root.getChildren().add(rects[i][j]);
                    if (i == 0 || j == 0 || i == WIDTH - 1 || j == WIDTH - 1)
                    {
                        rects[i][j].setFill(Color.BLACK);
                    }
                    else rects[i][j].setFill(landType.getColor());
                }
            }
            repositionDisplay(root, tileSize, zoom, x, y);*/
        }
        updatePermanentDisplay(zoom);
    }
}

