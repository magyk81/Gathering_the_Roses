package Trait;

import Util.LanguageEnum;

public enum AttributeEnum
{
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
            },
    LIGHT
            {
                public TypeEnum getType(boolean elemental)
                {
                    if (elemental) return TypeEnum.ELECTRICAL;
                    return TypeEnum.ANGELIC;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Light";
                        case SPANISH: return "Luz";
                        case FRENCH: return "Lumière";
                        case GERMAN: return "Licht";
                        default: return "";
                    }
                }
            },
    WATER
            {
                public TypeEnum getType(boolean elemental) { return TypeEnum.WATERY; }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Water";
                        case SPANISH: return "Agua";
                        case FRENCH: return "Eau";
                        case GERMAN: return "Wasser";
                        default: return "";
                    }
                }
            },
    FIRE
            {
                public TypeEnum getType(boolean elemental) { return TypeEnum.FIERY; }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Fire";
                        case SPANISH: return "Fuego";
                        case FRENCH: return "Feu";
                        case GERMAN: return "Feuer";
                        default: return "";
                    }
                }
            },
    EARTH
            {
                public TypeEnum getType(boolean elemental) { return TypeEnum.EARTHY; }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Earth";
                        case SPANISH: return "Tierra";
                        case FRENCH: return "Terre";
                        case GERMAN: return "Erde";
                        default: return "";
                    }
                }
            },
    WIND
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Wind";
                        case SPANISH: return "Viento";
                        case FRENCH: return "Vent";
                        case GERMAN: return "Wind";
                        default: return "";
                    }
                }
            },
    DARK
            {
                public TypeEnum getType(boolean elemental) { return TypeEnum.DEMONIC; }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Dark";
                        case SPANISH: return "Oscuro";
                        case FRENCH: return "Foncé";
                        case GERMAN: return "Dunkel";
                        default: return "";
                    }
                }
            },
    DIVINE
            {
                public TypeEnum getType(boolean elemental) { return TypeEnum.DIVINE; }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Divine";
                        case SPANISH: return "Divino";
                        case FRENCH: return "Divin";
                        case GERMAN: return "Göttlich";
                        default: return "";
                    }
                }
            };

    public TypeEnum getType(boolean elemental) { return TypeEnum.ANGELIC; }

    public String getName(LanguageEnum language) { return this.name(); }
}