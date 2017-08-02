package Trait;

import javafx.scene.paint.Color;

public enum LandTypeEnum
{
    WASTELAND
            {
                public Color getColor() { return Color.YELLOW; }
            },
    PLAINS
            {
                public Color getColor() { return Color.WHITE; }
            },
    ISLAND
            {
                public Color getColor() { return Color.BLUE; }
            },
    SWAMP
            {
                public Color getColor() { return Color.DARKGRAY; }
            },
    MOUNTAIN
            {
                public Color getColor() { return Color.RED; }
            },
    FOREST
            {
                public Color getColor() { return Color.GREEN; }
            },
    NORMAL;

    public Color getColor() { return Color.GRAY; }
}
