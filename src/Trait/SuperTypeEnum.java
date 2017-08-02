package Trait;

import Util.LanguageEnum;

/**
 * Created by Robin on 2/22/2017.
 */
public enum SuperTypeEnum
{
    SORCERY
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Sorcery";
                        case SPANISH: return "Brujería";
                        case FRENCH: return "Sorcellerie";
                        case GERMAN: return "Zauberei";
                        default: return "";
                    }
                }
            },
    ENCHANTMENT
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Enchantment";
                        case SPANISH: return "Encantamiento";
                        case FRENCH: return "Enchantement";
                        case GERMAN: return "Verzauberung";
                        default: return "";
                    }
                }
            },
    ARTIFACT
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Artifact";
                        case SPANISH: return "Artefacto";
                        case FRENCH: return "Artifact";
                        case GERMAN: return "Artefakt";
                        default: return "";
                    }
                }
            },
    CREATURE
            {
                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Creature";
                        case SPANISH: return "Criatura";
                        case FRENCH: return "Créature";
                        case GERMAN: return "Geschöpf";
                        default: return "";
                    }
                }
            };

    public String getName(LanguageEnum language) { return this.name(); }
}
