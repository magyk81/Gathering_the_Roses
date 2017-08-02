package Trait;

import Util.LanguageEnum;
import javafx.scene.paint.Color;

public enum ColorEnum
{
    WHITE
            {
                public Color getColor()
                {
                    return Color.WHITE;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "White";
                        case SPANISH: return "Blanco";
                        case FRENCH: return "Blanc";
                        case GERMAN: return "Weiß";
                        default: return "";
                    }
                }
            },
    GREEN
            {
                public Color getColor()
                {
                    return Color.GREEN;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Green";
                        case SPANISH: return "Verde";
                        case FRENCH: return "Vert";
                        case GERMAN: return "Grün";
                        default: return "";
                    }
                }
            },
    RED
            {
                public Color getColor()
                {
                    return Color.RED;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Red";
                        case SPANISH: return "Rojo";
                        case FRENCH: return "Rouge";
                        case GERMAN: return "Rot";
                        default: return "";
                    }
                }
            },
    BLACK
            {
                public Color getColor()
                {
                    return Color.BLACK;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Black";
                        case SPANISH: return "Negro";
                        case FRENCH: return "Noir";
                        case GERMAN: return "Schwarz";
                        default: return "";
                    }
                }
            },
    BLUE
            {
                public Color getColor()
                {
                    return Color.BLUE;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Blue";
                        case SPANISH: return "Azul";
                        case FRENCH: return "Bleu";
                        case GERMAN: return "Blau";
                        default: return "";
                    }
                }
            };

    public Color getColor()
    {
        return Color.GRAY;
    }

    public String getName(LanguageEnum language)
    {
        switch (language)
        {
            case ENGLISH: return "Error";
            case SPANISH: return "Error";
            case ITALIAN: return "Errore";
            case FRENCH: return "Erreur";
            case GERMAN: return "Fehler";
            case WAPANESE: return "誤差";
            default: return "";
        }
    }
}
