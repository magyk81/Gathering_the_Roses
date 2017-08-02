package Common;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Robin on 4/10/2017.
 */
public class Trail
{
    private boolean complete;
    private Group root;

    private LinkedList<Coord> list;
    private HashSet<Rectangle> rects;

    Trail(int x, int y, Group root)
    {
        complete = false;
        this.root = root;
        list = new LinkedList<>();
        list.offer(new Coord(x, y));
        rects = new HashSet<>();
    }

    public void mark(int x, int y)
    {
        Coord newCoord = new Coord(x, y);
        if (!list.peekLast().isAdjacent(newCoord)) fillGap(newCoord, list.peekLast());
        list.offer(newCoord);
        Rectangle rect = new Rectangle(x, y, 1.0, 1.0);
        rect.setFill(Color.BLACK);
        rects.add(rect);
        root.getChildren().add(rect);
    }

    public void markEnd(int x, int y)
    {
        mark(x, y);
        complete = true;
        System.out.println(list.peekFirst() + " " + list.peekLast());
    }

    public boolean isComplete() { return complete; }

    public HashSet<Rectangle> getRects() { return rects; }

    private void fillGap(Coord newCoord, Coord farCoord)
    {
        int xDir, yDir;
        if (newCoord.x == farCoord.x) xDir = 0;
        else if (newCoord.x < farCoord.x) xDir = 1;
        else xDir = -1;
        if (newCoord.y == farCoord.y) yDir = 0;
        else if (newCoord.y < farCoord.y) yDir = 1;
        else yDir = -1;
        mark(newCoord.x + xDir, newCoord.y + yDir);
    }

    private class Coord
    {
        int x, y;
        Coord(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public boolean isAdjacent(Coord other)
        {
            if (Math.abs(other.x - x) < 2 && Math.abs(other.y - y) < 2) return true;
            return false;
        }

        public String toString()
        {
            return "[" + x + ", " + y + "]";
        }
    }
}
