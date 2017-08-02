package Common;

/**
 * Created by Robin on 6/28/2017.
 */
public enum DirectionEnum
{
    NORTH
            {
                public int getX() { return 0; }
                public int getY() { return -1; }
                public DirectionEnum opposite() { return SOUTH; }
            },
    EAST
            {
                public int getX() { return -1; }
                public int getY() { return 0; }
                public DirectionEnum opposite() { return WEST; }
            },
    SOUTH
            {
                public int getX() { return 0; }
                public int getY() { return 1; }
                public DirectionEnum opposite() { return NORTH; }
            },
    WEST
            {
                public int getX() { return 1; }
                public int getY() { return 0; }
                public DirectionEnum opposite() { return EAST; }
            },
    NONE;

    public int getX() { return 0; }
    public int getY() { return 0; }
    public DirectionEnum opposite() { return NONE; }
}
