package Trait;

import Util.LanguageEnum;

import java.util.HashSet;

public enum RaceEnum
{
    ADVISOR         // 000
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    AETHERBORN      // 001
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.ANGELIC);
                    return types;
                }
            },
    ANGEL           // 002
            {
                public boolean isAlly = true;

                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.ANGELIC);
                    return types;
                }
            },
    ANTELOPE        // 003
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    APE             // 004
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    ARCHER          // 005
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    ARCHON          // 006
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.ANGELIC);
                    return types;
                }
            },
    ARTIFICER       // 007
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    ASSASSIN        // 008
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    AUROCHS         // 009
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    AVATAR          // 010
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (!subRace) return types;
                    types.add(attribute.getType(false));
                    return types;
                }
            },
    BARBARIAN       // 011
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    BASILISK        // 012
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }
            },
    BAT             // 013
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    BEAR            // 014
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    BEAST           // 015
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    BERSERKER       // 016
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    BIRD            // 017
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.AVIAN);
                    return types;
                }
            },
    BOAR            // 018
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    CAMEL           // 019
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    CAT             // 020
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    CENTAUR         // 021
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.BESTIAL);
                        types.add(TypeEnum.WARRING);
                    }
                    return types;
                }
            },
    CHIMERA         // 022
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    CLERIC          // 023
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.SPELLCASTING);
                    return types;
                }
            },
    CLOWN
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.DEMONIC);
                        types.add(TypeEnum.SPELLCASTING);
                    }
                    return types;
                }
            },
    COCKATRICE      // 024
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }
            },
    CONSTRUCT       // 025
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.MECHANICAL);
                    return types;
                }
            },
    CRAB            // 026
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WATERY);
                    return types;
                }
            },
    CROCODILE       // 027
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }
            },
    CYCLOPS         // 028
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.BESTIAL);
                        types.add(TypeEnum.WARRING);
                    }
                    return types;
                }
            },
    DEMON           // 029
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.DEMONIC);
                    return types;
                }
            },
    DEVIL           // 030
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.DEMONIC);
                    return types;
                }
            },
    DINOSAUR        // 031
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }
            },
    DJINN           // 032
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.ANGELIC);
                    return types;
                }
            },
    DRAGON          // 033
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.DRACONIC);
                    return types;
                }
            },
    DRAKE           // 034
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.DRACONIC);
                    return types;
                }
            },
    DRONE           // 035
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.MECHANICAL);
                    return types;
                }
            },
    DRUID           // 036
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.SPELLCASTING);
                    return types;
                }
            },
    DRYAD
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BOTANIC);
                    if (subRace) types.add(TypeEnum.ANGELIC);
                    return types;
                }
            },
    DWARF           // 037
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    EFREET          // 038
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.ANGELIC);
                    return types;
                }
            },
    ELDRAZI         // 039
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.DIVINE);
                        types.add(TypeEnum.DEMONIC);
                    }
                    return types;
                }
            },
    ELEMENTAL       // 040
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(attribute.getType(true));
                    return types;
                }
            },
    ELEPHANT        // 041
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    ELF             // 042
            {
                public boolean isAlly = true;

                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.ANGELIC);
                        types.add(TypeEnum.WARRING);
                    }
                    return types;
                }
            },
    ELK             // 043
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    FAERIE          // 044
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.ANGELIC);
                    return types;
                }
            },
    FISH            // 045
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.PICSINE);
                    return types;
                }
            },
    FOX             // 046
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    FROG            // 047
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WATERY);
                    return types;
                }
            },
    FUNGUS          // 048
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BOTANIC);
                    return types;
                }
            },
    GARGOYLE        // 049
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(attribute.getType(false));
                        return types;
                    }
                    types.add(TypeEnum.EARTHY);
                    return types;
                }
            },
    GIANT           // 050
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    GOAT            // 051
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    GOBLIN          // 052
            {
                public boolean isAlly = true;

                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.DEMONIC);
                        types.add(TypeEnum.WARRING);
                    }
                    return types;
                }
            },
    GOD             // 053
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.DIVINE);
                    return types;
                }
            },
    GOLEM           // 054
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.EARTHY);
                    return types;
                }
            },
    GORGON          // 055
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.DEMONIC);
                        types.add(TypeEnum.REPTILIAN);
                    }
                    return types;
                }
            },
    GREMLIN         // 056
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.DEMONIC);
                    return types;
                }
            },
    GRIFFIN         // 057
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.AVIAN);
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    HAG             // 058
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.SPELLCASTING);
                    return types;
                }
            },
    HARPY           // 059
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.DEMONIC);
                    types.add(TypeEnum.AVIAN);
                    return types;
                }
            },
    HELLION         // 060
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.FIERY);
                    return types;
                }
            },
    HIPPOGRIFF      // 061
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.AVIAN);
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    HOMUNCULUS      // 062
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    HORROR          // 063
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.DEMONIC);
                    return types;
                }
            },
    HORSE           // 064
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    HOUND           // 065
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    HUMAN           // 066
            {
                public boolean isAlly = true;

                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    HYDRA           // 067
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.DRACONIC);
                    return types;
                }
            },
    ILLUSION        // 068
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(attribute.getType(false));
                    }
                    return types;
                }
            },
    IMP             // 069
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.DEMONIC);
                    return types;
                }
            },
    INSECT          // 070
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.INSECTILE);
                    return types;
                }
            },
    JACKAL          // 071
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    JELLYFISH       // 072
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WATERY);
                    return types;
                }
            },
    KIRIN           // 073
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.ANGELIC);
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    KITHKIN         // 074
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    KNIGHT          // 075
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    KOR             // 076
            {
                public boolean isAlly = true;

                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    KRAKEN          // 077
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.WATERY);
                        types.add(TypeEnum.PICSINE);
                    }
                    return types;
                }
            },
    LAMMASU         // 078
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.AVIAN);
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    LEECH           // 079
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.INSECTILE);
                    return types;
                }
            },
    LEVIATHAN       // 080
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.PICSINE);
                    return types;
                }
            },
    LIZARD          // 081
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }
            },
    MERFOLK         // 082
            {
                public boolean isAlly = true;

                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.PICSINE);
                        types.add(TypeEnum.WARRING);
                    }
                    return types;
                }
            },
    MINOTAUR        // 083
            {
                public boolean isAlly = true;

                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    MONK            // 084
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    MOONFOLK        // 085
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.ANGELIC);
                        types.add(TypeEnum.WARRING);
                    }
                    return types;
                }
            },
    NAGA            // 086
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }
            },
    NIGHTMARE       // 087
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.DEMONIC);
                    return types;
                }
            },
    NINJA           // 088
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    NOGGLE          // 089
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.WARRING);
                        types.add(TypeEnum.BESTIAL);
                    }
                    return types;
                }
            },
    NYMPH           // 090
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.ANGELIC);
                    return types;
                }
            },
    OCTOPUS         // 091
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.PICSINE);
                        types.add(TypeEnum.WATERY);
                    }
                    return types;
                }
            },
    OGRE            // 092
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.WARRING);
                        types.add(TypeEnum.BESTIAL);
                        types.add(TypeEnum.DEMONIC);
                    }
                    return types;
                }
            },
    OOZE            // 093
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WATERY);
                    return types;
                }
            },
    ORC             // 094
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.WARRING);
                        types.add(TypeEnum.DEMONIC);
                    }
                    return types;
                }
            },
    OUPHE           // 095
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.BESTIAL);
                        types.add(TypeEnum.DEMONIC);
                        types.add(TypeEnum.WARRING);
                    }
                    return types;
                }
            },
    OX              // 096
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    PEGASUS         // 097
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.AVIAN);
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    PHOENIX         // 098
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.AVIAN);
                    types.add(TypeEnum.FIERY);
                    return types;
                }
            },
    PILOT           // 099
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.WARRING);
                    }
                    return types;
                }
            },
    PLANT           // 100
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BOTANIC);
                    return types;
                }
            },
    PROCESSOR       // 101
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.MECHANICAL);
                    return types;
                }
            },
    RABBIT          // 102
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    RAT             // 103
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    RHINO           // 104
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }
            },
    ROGUE           // 105
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    SALAMANDER      // 106
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }
            },
    SAMURAI         // 107
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    SATYR           // 108
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.WARRING);
                        types.add(TypeEnum.BESTIAL);
                    }
                    return types;
                }
            },
    SCARECROW       // 109
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.MECHANICAL);
                    return types;
                }
            },
    SCION           // 110
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (!subRace) return types;
                    types.add(attribute.getType(true));
                    return types;
                }
            },
    SCORPION        // 111
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.INSECTILE);
                    return types;
                }
            },
    SCOUT           // 112
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }
            },
    SHADE           // 113
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.DEMONIC);
                    types.add(TypeEnum.UNDEAD);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Shade";
                        case SPANISH: return "Sombra";
                        case ITALIAN: return "Ombra";
                        case FRENCH: return "Ombre";
                        case GERMAN: return "Schatten";
                        default: return "ERROR";
                    }
                }
            },
    SHAMAN          // 114
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.SPELLCASTING);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Shaman";
                        case SPANISH: return "Chamán";
                        case ITALIAN: return "Sciamano";
                        case FRENCH: return "Chaman";
                        case GERMAN: return "Schamane";
                        default: return "ERROR";
                    }
                }
            },
    SHAPESHIFTER    // 115
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(attribute.getType(false));
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Shapeshifter";
                        case SPANISH: return "Cambiador de formas";
                        case ITALIAN: return "Spostatore di forme";
                        case FRENCH: return "Décaleur de forme";
                        case GERMAN: return "Formschieber";
                        default: return "ERROR";
                    }
                }
            },
    SHEEP           // 116
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Sheep";
                        case SPANISH: return "Borrega";
                        case ITALIAN: return "Pecora";
                        case FRENCH: return "Brebis";
                        case GERMAN: return "Schaf";
                        default: return "ERROR";
                    }
                }
            },
    SIREN           // 117
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.AVIAN);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Siren";
                        case SPANISH: return "Sirena";
                        case ITALIAN: return "Sirena";
                        case FRENCH: return "Sirène";
                        case GERMAN: return "Sirene";
                        default: return "ERROR";
                    }
                }
            },
    SKELETON        // 118
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.UNDEAD);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Skeleton";
                        case SPANISH: return "Esqueleto";
                        case ITALIAN: return "Scheletro";
                        case FRENCH: return "Squelette";
                        case GERMAN: return "Skelett";
                        default: return "ERROR";
                    }
                }
            },
    SLUG            // 119
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WATERY);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Slug";
                        case SPANISH: return "Babosa";
                        case ITALIAN: return "Lumaca";
                        case FRENCH: return "Limace";
                        case GERMAN: return "Nacktschnecke";
                        default: return "ERROR";
                    }
                }
            },
    SNAKE           // 120
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Snake";
                        case SPANISH: return "Serpiente";
                        case ITALIAN: return "Serpente";
                        case FRENCH: return "Serpent";
                        case GERMAN: return "Schlange";
                        default: return "ERROR";
                    }
                }
            },
    SOLDIER         // 121
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Soldier";
                        case SPANISH: return "Soldado";
                        case ITALIAN: return "Soldato";
                        case FRENCH: return "Soldat";
                        case GERMAN: return "Soldat";
                        default: return "ERROR";
                    }
                }
            },
    SPECTER         // 122
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.DEMONIC);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Specter";
                        case SPANISH: return "Espectro";
                        case ITALIAN: return "Spettro";
                        case FRENCH: return "Spectre";
                        case GERMAN: return "Gespenst";
                        default: return "ERROR";
                    }
                }
            },
    SPHINX          // 123
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.AVIAN);
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Sphinx";
                        case SPANISH: return "Esfinge";
                        case ITALIAN: return "Sfinge";
                        case FRENCH: return "Sphinx";
                        case GERMAN: return "Sphinx";
                        default: return "ERROR";
                    }
                }
            },
    SPIDER          // 124
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.INSECTILE);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Spider";
                        case SPANISH: return "Araña";
                        case ITALIAN: return "Ragno";
                        case FRENCH: return "Araignée";
                        case GERMAN: return "Spinne";
                        default: return "ERROR";
                    }
                }
            },
    SPIRIT          // 125
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (attribute == AttributeEnum.DARK) types.add(TypeEnum.UNDEAD);
                    types.add(TypeEnum.ANGELIC);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Spirit";
                        case SPANISH: return "Espíritu";
                        case ITALIAN: return "Spirito";
                        case FRENCH: return "Espirit";
                        case GERMAN: return "Geist";
                        default: return "ERROR";
                    }
                }
            },
    SQUID           // 126
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.PICSINE);
                        types.add(TypeEnum.WATERY);
                    }
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Squid";
                        case SPANISH: return "Calamar";
                        case ITALIAN: return "Calamaro";
                        case FRENCH: return "Calamar";
                        case GERMAN: return "Tintenfisch";
                        default: return "ERROR";
                    }
                }
            },
    SQUIRREL        // 127
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Squirrel";
                        case SPANISH: return "Ardilla";
                        case ITALIAN: return "Scoiattolo";
                        case FRENCH: return "Écureuil";
                        case GERMAN: return "Eichhörnchen";
                        default: return "ERROR";
                    }
                }
            },
    STARFISH        // 128
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WATERY);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Starfish";
                        case SPANISH: return "Estrella de mar";
                        case ITALIAN: return "Stella di mare";
                        case FRENCH: return "Étoile de mer";
                        case GERMAN: return "Seestern";
                        default: return "ERROR";
                    }
                }
            },
    THOPTER         // 129
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.MECHANICAL);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Thopter";
                        case SPANISH: return "Thóptero";
                        case ITALIAN: return "Thottero";
                        case FRENCH: return "Thoptère";
                        case GERMAN: return "Thrauber";
                        default: return "ERROR";
                    }
                }
            },
    THRULL          // 130
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.UNDEAD);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Thrull";
                        case SPANISH: return "Thrull";
                        case ITALIAN: return "Thrull";
                        case FRENCH: return "Thrull";
                        case GERMAN: return "Thrull";
                        default: return "ERROR";
                    }
                }
            },
    TREEFOLK        // 131
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BOTANIC);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Treefolk";
                        case SPANISH: return "Gente arbol";
                        case ITALIAN: return "Silvantropo";
                        case FRENCH: return "Gens d'arbre";
                        case GERMAN: return "Baummenschen";
                        default: return "ERROR";
                    }
                }
            },
    TROLL           // 132
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Troll";
                        case SPANISH: return "Gnomo";
                        case ITALIAN: return "Gnomo";
                        case FRENCH: return "Troll";
                        case GERMAN: return "Troll";
                        default: return "ERROR";
                    }
                }
            },
    TURTLE          // 133
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace)
                    {
                        types.add(TypeEnum.WATERY);
                        types.add(TypeEnum.PICSINE);
                    }
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Turtle";
                        case SPANISH: return "Tortuga";
                        case ITALIAN: return "Tartaruga";
                        case FRENCH: return "Tortue";
                        case GERMAN: return "Schildkröte";
                        default: return "ERROR";
                    }
                }
            },
    UNICORN         // 134
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Unicorn";
                        case SPANISH: return "Unicornio";
                        case ITALIAN: return "Unicorno";
                        case FRENCH: return "Licorne";
                        case GERMAN: return "Einhorn";
                        default: return "ERROR";
                    }
                }
            },
    VAMPIRE         // 135
            {
                public boolean isAlly = true;

                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.UNDEAD);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Vampire";
                        case SPANISH: return "Vampiro";
                        case ITALIAN: return "Vampiro";
                        case FRENCH: return "Vampire";
                        case GERMAN: return "Vampir";
                        default: return "ERROR";
                    }
                }
            },
    VEDALKEN        // 136
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Vedalken";
                        case SPANISH: return "Vedalken";
                        case ITALIAN: return "Vedalken";
                        case FRENCH: return "Vedalken";
                        case GERMAN: return "Vedalken";
                        default: return "ERROR";
                    }
                }
            },
    VIASHINO        // 137
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.WARRING);
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Viashino";
                        case SPANISH: return "Viashino";
                        case ITALIAN: return "Viashino";
                        case FRENCH: return "Viashino";
                        case GERMAN: return "Viashino";
                        default: return "ERROR";
                    }
                }
            },
    WALL            // 138
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(attribute.getType(true));
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Wall";
                        case SPANISH: return "Muralla";
                        case ITALIAN: return "Muro";
                        case FRENCH: return "Mur";
                        case GERMAN: return "Mauer";
                        default: return "ERROR";
                    }
                }
            },
    WARRIOR         // 139
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.WARRING);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Warrior";
                        case SPANISH: return "Guerrero";
                        case ITALIAN: return "Guerriero";
                        case FRENCH: return "Guerrier";
                        case GERMAN: return "Krieger";
                        default: return "ERROR";
                    }
                }
            },
    WEIRD           // 140
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(attribute.getType(true));
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Weird";
                        case SPANISH: return "Extraño";
                        case ITALIAN: return "Strano";
                        case FRENCH: return "Étrange";
                        case GERMAN: return "Seltsam";
                        default: return "ERROR";
                    }
                }
            },
    WEREWOLF        // 141
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Werewolf";
                        case SPANISH: return "Hombre-lobo";
                        case ITALIAN: return "Mannaro";
                        case FRENCH: return "Loup-garou";
                        case GERMAN: return "Werwolf";
                        default: return "ERROR";
                    }
                }
            },
    WHALE           // 142
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.PICSINE);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Whale";
                        case SPANISH: return "Ballena";
                        case ITALIAN: return "Balena";
                        case FRENCH: return "Baleine";
                        case GERMAN: return "Wal";
                        default: return "ERROR";
                    }
                }
            },
    WIZARD          // 143
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.SPELLCASTING);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Wizard";
                        case SPANISH: return "Mago";
                        case ITALIAN: return "Stregone";
                        case FRENCH: return "Sorcier";
                        case GERMAN: return "Zuberer";
                        default: return "ERROR";
                    }
                }
            },
    WOLF            // 144
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Wolf";
                        case SPANISH: return "Lobo";
                        case ITALIAN: return "Lupo";
                        case FRENCH: return "Loup";
                        case GERMAN: return "Wolf";
                        default: return "ERROR";
                    }
                }
            },
    WORM            // 145
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.INSECTILE);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Worm";
                        case SPANISH: return "Gusano";
                        case ITALIAN: return "Verme";
                        case FRENCH: return "Ver";
                        case GERMAN: return "Wurm";
                        default: return "ERROR";
                    }
                }
            },
    WURM            // 146
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    if (subRace) types.add(TypeEnum.INSECTILE);
                    types.add(TypeEnum.REPTILIAN);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Wurm";
                        case SPANISH: return "Lombriz";
                        case ITALIAN: return "Lombrico";
                        case FRENCH: return "Asticot";
                        case GERMAN: return "Holzwurm";
                        default: return "ERROR";
                    }
                }
            },
    YETI            // 147
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.BESTIAL);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Yeti";
                        case SPANISH: return "Yeti";
                        case ITALIAN: return "Yeti";
                        case FRENCH: return "Yeti";
                        case GERMAN: return "Yeti";
                        default: return "ERROR";
                    }
                }
            },
    ZOMBIE          // 148
            {
                public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute)
                {
                    types.clear();
                    types.add(TypeEnum.UNDEAD);
                    return types;
                }

                public String getName(LanguageEnum language)
                {
                    switch (language)
                    {
                        case ENGLISH: return "Zombie";
                        case SPANISH: return "Zombi";
                        case ITALIAN: return "Zombie";
                        case FRENCH: return "Zombi";
                        case GERMAN: return "Zombie";
                        default: return "ERROR";
                    }
                }
            };

    public boolean isAlly = false;

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
            default: return "ERROR";
        }
    }

    public HashSet<TypeEnum> getType(boolean subRace, AttributeEnum attribute) { return null; }

    public HashSet<TypeEnum> types = new HashSet<>();
}