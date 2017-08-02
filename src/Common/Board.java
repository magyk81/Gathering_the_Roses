package Common;

import Trait.LandTypeEnum;
import Trait.SuperTypeEnum;
import javafx.application.Platform;
import javafx.scene.Group;

import java.util.*;

/**
 * Created by Robin on 11/1/2016.
 */
public class Board extends Thread
{
    private Group root;

    //private final int TILE_SIZE = 10; // WIDTH and HEIGHT must be divisible by TILE_SIZE
    //private final int FILL = 3000 / (TILE_SIZE * TILE_SIZE);

    private LandTypeEnum neutralLandType;

    private int filled;
    private int empty;

    // How many lands long. Always a square. Assigned by setUpInitialLand().
    private int length;

    private HashSet<Permanent> permanents;
    private LinkedList<Trail> trails;
    private HashSet<Land> lands;

    private volatile boolean paused;
    private volatile boolean gameOver;

    /**
     * Instantiated once every match
     */
    public Board(Group root, LandTypeEnum neutralLand)
    {
        this.root = root;

        this.neutralLandType = neutralLand;

        //empty = (WIDTH * HEIGHT) / (TILE_SIZE * TILE_SIZE);

        permanents = new HashSet<>();
        trails = new LinkedList<>();
        lands = new HashSet<>();

        paused = false;
        gameOver = false;
    }

    public Board(Group root)
    {
        this(root, LandTypeEnum.NORMAL);
    }

    @Override
    public void run()
    {
        while (!gameOver && !paused)
        {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> tick());
        }
    }

    private void tick()
    {
        for (Permanent perm : permanents)
        {
            perm.tick();
        }
        for (UserView userView : Match.getUserViews())
        {
            userView.updatePositioning();
        }
    }

    public void spawnTrail(int x, int y, boolean finish)
    {
        if (trails.isEmpty() || trails.peek().isComplete()) trails.addFirst(new Trail(x, y, root));
        else if (!finish) trails.peek().mark(x, y);
        else trails.peek().markEnd(x, y);
    }

    public int getLength()
    {
        return length;
    }

    /**
     * Work in progress
     * @param x
     * @param y
     * @param land
     * @param dir
     */
    public void spawnLand(int x, int y, Land land, DirectionEnum dir)
    {
        //if (!lands.get(x).get(y).isNeutral()) shiftLands(x, y, dir);
    }

    /**
     * Work in progress
     * @param x
     * @param y
     * @param dir
     */
    private void shiftLands(int x, int y, DirectionEnum dir)
    {

    }

    /**
     * Fills a space circularly from an origin point
     * @param x - origin
     * @param y - origin
     */
    /*public boolean spawnLand(int x, int y, int terrain)
    {
        filled = FILL;
        class Tile
        {
            private int x, y;
            private Tile(int x, int y)
            {
                this.x = x;
                this.y = y;
            }
        }

        List<Tile> list = new ArrayList<>();
        List<Tile> buffer = new ArrayList<>();
        Queue<Tile> queue = new LinkedList<>();
        if (setTile(x, y, terrain))
        {
            Tile tile = new Tile(x, y);
            queue.add(tile);
            list.add(tile);
            buffer.add(tile);
        }
        else return false;

        while (filled > 0)
        {
            if (list.isEmpty())
            {
                filled = 0;
                break;
            }
            for (Tile tile : list)
            {
                Tile polled = queue.poll();
                buffer.remove(polled);
                if (--filled <= 0 | tile == null)
                {
                    filled = 0;
                    break;
                }
                Tile temp1 = new Tile(polled.x + TILE_SIZE, polled.y);
                Tile temp2 = new Tile(polled.x - TILE_SIZE, polled.y);
                Tile temp3 = new Tile(polled.x, polled.y + TILE_SIZE);
                Tile temp4 = new Tile(polled.x, polled.y - TILE_SIZE);
                if (setTile(temp1.x, temp1.y, terrain))
                {
                    queue.add(temp1);
                    buffer.add(temp1);
                }
                if (setTile(temp2.x, temp2.y, terrain))
                {
                    queue.add(temp2);
                    buffer.add(temp2);
                }
                if (setTile(temp3.x, temp3.y, terrain))
                {
                    queue.add(temp3);
                    buffer.add(temp3);
                }
                if (setTile(temp4.x, temp4.y, terrain))
                {
                    queue.add(temp4);
                    buffer.add(temp4);
                }
                if (empty <= 0)
                {
                    filled = 0;
                    break;
                }
            }
            list.clear();
            list.addAll(buffer);
        }
        filled = 0;
        for (Permanent perm : permanents)
        {
            root.getChildren().remove(perm.getPiece());
            root.getChildren().add(perm.getPiece());
        }
        return true;
    }*/

    public void spawnPermanent(Card card, Land land, int x, int y)
    {
        if (card.hasSuperType(SuperTypeEnum.CREATURE)) spawnCreature(card, land, x, y);
    }

    private void spawnCreature(Card card, Land land, int x, int y)
    {
        Creature spawn = new Creature(card, land, x, y);
        permanents.add(spawn);
        root.getChildren().add(spawn.getPiece());
    }

    /*public int getTileSize()
    {
        return TILE_SIZE;
    }*/

    /*public int getTerrain(int x, int y)
    {
        return terrain[x][y];
    }*/

    /**
     * Set one unoccupied tile to a certain terrain
     * @param  - position
     * @param  - position
     * @return false if out of bounds or tile is already occupied
     */
    /*private boolean setTile(int x, int y, int terrain)
    {
        if (x >= WIDTH || y >= HEIGHT || x < 0 || y < 0) return false;
        if (this.terrain[x][y] > 0) return false;
        if (empty-- <= 0)
        {
            System.out.println("to the brim");
            return false;
        }
        for (int i = 0 ; i < TILE_SIZE ; i++)
        {
            for (int j = 0 ; j < TILE_SIZE ; j++)
            {
                this.terrain[x + i][y + j] = terrain;
            }
        }
        tiles[x][y] = new Rectangle(x, y, TILE_SIZE, TILE_SIZE);
        tiles[x][y].setFill(getTerrainColor(terrain));
        root.getChildren().add(tiles[x][y]);
        return true;
    }*/

    /**
     * Set up the initial neutral zone where the players will start.
     */
    public void setUpInitialLand(int numberOfPlayers, int stageWidth, int stageHeight)
    {
        length = 0;
        // Ensure that there are enough lands to start with.
        while (length * length < numberOfPlayers * 4) length++;

        Land[][] lands = new Land[length][length];
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                //lands[i][j] = new Land(neutralLandType);
                // for testing:
                if (i == 0 && j != 0) lands[i][j] = new Land(LandTypeEnum.FOREST);
                else if (j == 0 && i != 0) lands[i][j] = new Land(LandTypeEnum.ISLAND);
                else if (i == 1) lands[i][j] = new Land(LandTypeEnum.MOUNTAIN);
                else if (j == 1) lands[i][j] = new Land(LandTypeEnum.PLAINS);
                else lands[i][j] = new Land(neutralLandType);
            }
        }

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                int north, west, south, east;
                if (j == 0) north = length - 1; else north = j - 1;
                if (i == 0) west = length - 1; else west = i - 1;
                if (j == length - 1) south = 0; else south = j + 1;
                if (i == length - 1) east = 0; else east = i + 1;
                lands[i][j].greetNeighbors(lands[i][north], lands[west][j],
                        lands[i][south], lands[east][j]);

                this.lands.add(lands[i][j]);
            }
        }

        for (UserView userView : Match.getUserViews())
        {
            userView.assignStageDimensions(stageWidth, stageHeight);
            userView.setBoardLength(length);
            userView.assignCornerland(lands[0][0]); // TODO: Change so that it's a different cornerland for each player
            userView.updatePositioning();
        }
    }
}
