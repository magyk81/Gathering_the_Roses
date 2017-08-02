package Common;

import Trait.ColorEnum;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;

/**
 * Created by Robin on 12/22/2016.
 */
public class Creature extends Permanent
{
    private Card card;
    private Land land;

    private int upper_bound, lower_bound, left_bound, right_bound;

    private Color colorNormal, colorSelected;

    public Creature(Card card, Land land, int x, int y)
    {
        this.card = card;
        setSize(card.getSize());
        this.land = land;
        land.addPermanent(this);
        setX(x);
        setY(y);
        /*upper_bound = y - size;
        lower_bound = y + size;
        left_bound = x - size;
        right_bound = x + size;*/

        for (ColorEnum color : card.getColors()) { colorNormal = color.getColor().darker(); }
        colorSelected = Color.PINK;

        piece = new Rectangle(getPieceX(1), getPieceY(1), getPieceSize(1), getPieceSize(1));
        piece.setFill(colorNormal);
    }

    public void move(int x, int y)
    {
        //posX += x;
        //posY += y;
        //piece.setX(piece.getX() + x);
        //piece.setY(piece.getY() + y);
        setX(getX() + 1);
    }

    public void tick()
    {
        move(1,0);
    }

    //public int getX(int tileSize) { return posX / tileSize; }
    //public int getY(int tileSize) { return posY / tileSize; }

    public boolean inside(int x, int y)
    {
        if (y > lower_bound || y < upper_bound) return false;
        if (x > right_bound || x < left_bound) return false;
        return true;
    }

    public void changeColor(boolean select)
    {
        if (select) piece.setFill(colorNormal);
        else piece.setFill(colorSelected);
    }
}
