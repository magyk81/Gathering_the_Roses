package Trait;

import Util.LanguageEnum;

public enum SuitEnum
{
    NORMAL
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Normal";
                        case SPANISH: return "Normal";
                        case FRENCH: return "Normal";
                        case GERMAN: return "Normal";
                        default: return "";
                    }
                }
            },
    EFFECT
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Effect";
                        case SPANISH: return "Efecto";
                        case FRENCH: return "Effet";
                        case GERMAN: return "Effekt";
                        default: return "";
                    }
                }
            },
    FUSION
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Fusion";
                        case SPANISH: return "Fusión";
                        case FRENCH: return "Fusion";
                        case GERMAN: return "Fusion";
                        default: return "";
                    }
                }
            },
    RITUAL
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Ritual";
                        case SPANISH: return "Ritual";
                        case FRENCH: return "Rituel";
                        case GERMAN: return "Ritual";
                        default: return "";
                    }
                }
            },
    RED
            {
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
    YELLOW
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Yellow";
                        case SPANISH: return "Amarillo";
                        case FRENCH: return "Jaune";
                        case GERMAN: return "Gelb";
                        default: return "";
                    }
                }
            },
    MAGIC
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Magic";
                        case SPANISH: return "Magia";
                        case FRENCH: return "Magie";
                        case GERMAN: return "Magie";
                        default: return "";
                    }
                }
            },
    TRAP
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Trap";
                        case SPANISH: return "Trampa";
                        case FRENCH: return "Piège";
                        case GERMAN: return "Falle";
                        default: return "";
                    }
                }
            };

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