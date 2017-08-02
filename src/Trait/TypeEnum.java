package Trait;

import Util.LanguageEnum;

import java.util.HashSet;

public enum TypeEnum
{
    DRACONIC
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Draconic";
                        case SPANISH: return "Dracónico";
                        case FRENCH: return "Draconique";
                        case GERMAN: return "Drakonisch";
                        default: return "";
                    }
                }
            },
    SPELLCASTING
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Spell-casting";
                        case SPANISH: return "Hechizando";
                        case FRENCH: return "Sortilège-coulée";
                        case GERMAN: return "Beschwören";
                        default: return "";
                    }
                }
            },
    UNDEAD
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Undead";
                        case SPANISH: return "Des-muerto";
                        case FRENCH: return "Mort-vivant";
                        case GERMAN: return "Untoten";
                        case WAPANESE: return "¯\\_(ツ)_/¯";
                        default: return "";
                    }
                }
            },
    WARRING
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Warring";
                        case SPANISH: return "Guerreando";
                        case FRENCH: return "Bagarreant";
                        case GERMAN: return "Kriegführend";
                        default: return "";
                    }
                }
            },
    BESTIAL
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Bestial";
                        case SPANISH: return "Bestial";
                        case FRENCH: return "Bestial";
                        case GERMAN: return "Tierisch";
                        default: return "";
                    }
                }
            },
    AVIAN
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Avian";
                        case SPANISH: return "Aviar";
                        case FRENCH: return "Aviaire";
                        case GERMAN: return "Avian";
                        default: return "";
                    }
                }
            },
    DEMONIC
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Demonic";
                        case SPANISH: return "Demoníaco";
                        case FRENCH: return "Démoniaque";
                        case GERMAN: return "Dämonisch";
                        default: return "";
                    }
                }
            },
    ANGELIC
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Angelic";
                        case SPANISH: return "Angélico";
                        case FRENCH: return "Angélique";
                        case GERMAN: return "Engelhaft";
                        default: return "";
                    }
                }
            },
    INSECTILE
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Insectile";
                        case SPANISH: return "Calesa";
                        case FRENCH: return "Boghei";
                        case GERMAN: return "Insektile";
                        default: return "";
                    }
                }
            },
    REPTILIAN
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Reptilian";
                        case SPANISH: return "Reptilero";
                        case FRENCH: return "Reptilien";
                        case GERMAN: return "Kreicherisch";
                        default: return "";
                    }
                }
            },
    PICSINE
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Piscine";
                        case SPANISH: return "Pisciforme";
                        case FRENCH: return "Pisciforme";
                        case GERMAN: return "Fischähnlich";
                        default: return "";
                    }
                }
            },
    MECHANICAL
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Mechanical";
                        case SPANISH: return "Maquinal";
                        case FRENCH: return "Mécanique";
                        case GERMAN: return "Mechanisch";
                        default: return "";
                    }
                }
            },
    ELECTRICAL
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Electrical";
                        case SPANISH: return "Eléctrico";
                        case FRENCH: return "Électrique";
                        case GERMAN: return "Elektrisch";
                        default: return "";
                    }
                }
            },
    WATERY
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Watery";
                        case SPANISH: return "Aguado";
                        case FRENCH: return "Détrempé";
                        case GERMAN: return "Tränend";
                        default: return "";
                    }
                }
            },
    FIERY
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Fiery";
                        case SPANISH: return "Ardiente";
                        case FRENCH: return "Fougueux";
                        case GERMAN: return "Feurig";
                        default: return "";
                    }
                }
            },
    EARTHY
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Earthy";
                        case SPANISH: return "Terroso";
                        case FRENCH: return "Terreux";
                        case GERMAN: return "Erdig";
                        default: return "";
                    }
                }
            },
    BOTANIC
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Botanic";
                        case SPANISH: return "Botánico";
                        case FRENCH: return "Botanique";
                        case GERMAN: return "Botanisch";
                        default: return "";
                    }
                }
            },
    DIVINE
            {
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

    public HashSet<RaceEnum> getRaces(boolean subRace)
    {
        HashSet<RaceEnum> races = new HashSet<>();
        for (RaceEnum race : RaceEnum.values())
        {
            races.add(race);
        }
        return races;
    }
}