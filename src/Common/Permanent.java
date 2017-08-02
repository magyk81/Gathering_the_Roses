package Common;

import javafx.scene.shape.Rectangle;

/**
 * Created by Robin on 7/3/2017.
 */
public class Permanent
{
    private int posX, posY;
    private int size, pieceSize;

    Rectangle piece;

    int getX() { return posX; }
    int getY() { return posY; }

    int getPieceX(int zoom) { return (posX - pieceSize) / zoom; }
    int getPieceY(int zoom) { return (posY - pieceSize) / zoom; }

    int getSize() { return size; }
    int getPieceSize(int zoom) { return pieceSize / zoom; }

    void setX(int x) { posX = x; }
    void setY(int y) { posY = y; }

    void setSize(int size)
    {
        this.size = size;
        pieceSize = size * 2 + 1;
    }

    Rectangle getPiece() { return piece; }

    void tick(){}
}
