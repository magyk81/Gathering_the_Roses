package Common;

import Abilities.Ability;
import Menus.Main;
import Trait.*;

import java.util.HashSet;

/**
 * Created by Robin on 10/23/2016.
 */

public class Card
{
    private HashSet<ColorEnum> colors;
    private String name;
    private SuitEnum suit;
    private AttributeEnum attribute;
    private String cost;
    private HashSet<RaceEnum> races;
    private HashSet<SuperTypeEnum> superTypes;
    private HashSet<Ability> abilities;
    private LandTypeEnum landType = null;
    private int level;
    private int atk;
    private int def;
    private int size;

    // Normal
    public Card(String name, AttributeEnum attribute, String races, String cost,
                Ability ability, int atk, int def, int size)
    {
        this.name = name;
        this.colors = new HashSet<>();
        this.races = new HashSet<>();
        this.abilities = new HashSet<>();
        this.abilities.add(ability);
        this.attribute = attribute;
        this.cost = cost;
        this.atk = atk;
        this.def = def;
        this.size = size;
        setLevel();
        setRaces(races);
        this.suit = setSuit();
        this.superTypes = new HashSet<>();
        this.superTypes.add(SuperTypeEnum.CREATURE);
    }

    // Effect
    public Card(String name, AttributeEnum attribute, String races, String cost,
                Ability ability1, Ability ability2, Ability ability3,
                int atk, int def, int size)
    {
        this(name, attribute, races, cost, ability1, atk, def, size);
        abilities.add(ability2);
        abilities.add(ability3);
        suit = setSuit();
    }

    // Fusion
    public Card(String name, AttributeEnum attribute, String races, String cost,
                Ability ability1, Ability ability2, Ability ability3,
                Ability ability4, Ability ability5, int atk, int def, int size)
    {
        this(name, attribute, races, cost, ability1, ability2, ability3, atk, def, size);
        abilities.add(ability4);
        abilities.add(ability5);
        suit = setSuit();
    }

    // Ritual
    public Card(String name, AttributeEnum attribute, String races, String cost,
                Ability ability1, Ability ability2, Ability ability3,
                Ability ability4, Ability ability5, Ability ability6,
                Ability ability7, int atk, int def, int size)
    {
        this(name, attribute, races, cost, ability1, ability2, ability3,
                ability4, ability5, atk, def, size);
        abilities.add(ability6);
        abilities.add(ability7);
        suit = setSuit();
    }

    // Red
    public Card(String name, AttributeEnum attribute, String races, String cost,
                Ability ability1, Ability ability2, Ability ability3,
                Ability ability4, Ability ability5, Ability ability6,
                Ability ability7, Ability ability8, Ability ability9,
                int atk, int def, int size)
    {
        this(name, attribute, races, cost, ability1, ability2, ability3,
                ability4, ability5, ability6, ability7, atk, def, size);
        abilities.add(ability8);
        abilities.add(ability9);
        suit = setSuit();
    }

    //
    public Card(String name, AttributeEnum attribute, String cost)
    {
        this.name = name;
        this.attribute = attribute;
        this.cost = cost;
        setLevel();
        suit = setSuit();
    }

    public Card(String name, LandTypeEnum landType)
    {
        this.name = name;
        this.landType = landType;
    }

    public String toString()
    {
        String colorString = "";
        for (ColorEnum color : colors)
        {
            colorString += color.getName(Main.language) + " ";
        }
        String typeString = "";
        String subtypesString = "";
        for (TypeEnum type : getTypes(false))
        {
            typeString += type.getName(Main.language) + " ";
        }
        HashSet<TypeEnum> subTypes = getTypes(true);
        subTypes.removeAll(getTypes(false));
        for (TypeEnum type : subTypes)
        {
            subtypesString += type.getName(Main.language) + " ";
        }
        String raceString = "";
        for (RaceEnum race : races)
        {
            raceString += race.getName(Main.language) + " ";
        }
        return "\nname:\t\t" + name + "\ncolor:\t\t" + colorString + "\nsuit:\t\t" +
                suit.getName(Main.language) + "\nattribute:\t" + attribute.getName(Main.language) +
                "\nlevel:\t\t" + level + "\ntypes:\t\t" + typeString + "\nsubtypes:\t" + subtypesString +
                "\nraces:\t\t" + raceString + "\ncost:\t\t" + cost + "\nattack:\t\t" + atk + "\ndefense:\t" +
                def;
    }

    public boolean hasSuperType(SuperTypeEnum superType)
    {
        return superTypes.contains(superType);
    }

    /**
     * Use this like a getter method
     * @param subRace - true to check for subtypes as well
     * @param type - what type you're checking for
     * @return - true if the creature has it, false if it doesn't have it
     */
    public boolean hasType(boolean subRace, TypeEnum type)
    {
        return getTypes(subRace).contains(type);
    }

    public int getLevel()
    {
        return level;
    }

    public SuitEnum getSuit()
    {
        return suit;
    }

    public AttributeEnum getAttribute()
    {
        return attribute;
    }

    public HashSet<ColorEnum> getColors() { return colors; }

    public HashSet<TypeEnum> getTypes(boolean notSub)
    {
        HashSet<TypeEnum> types = new HashSet<>();
        for (RaceEnum race : races)
        {
            for (TypeEnum type : race.getType(notSub, attribute))
            {
                types.add(type);
            }
        }
        return types;
    }

    public LandTypeEnum getLandType() { return landType; }

    public int getAtk()
    {
        return atk;
    }

    public int getDef()
    {
        return def;
    }

    public int getSize() { return size; }

    public boolean hasColor(ColorEnum color)
    {
        return colors.contains(color);
    }

    private void setLevel()
    {
        int level = 0;
        for (int i = 0 ; i < cost.length() ; i++)
        {
            switch (cost.charAt(i))
            {
                case ('W'):
                {
                    addColor(ColorEnum.WHITE);
                    level++;
                    break;
                }
                case ('G'):
                {
                    addColor(ColorEnum.GREEN);
                    level++;
                    break;
                }
                case ('R'):
                {
                    addColor(ColorEnum.RED);
                    level++;
                    break;
                }
                case ('B'):
                {
                    addColor(ColorEnum.BLACK);
                    level++;
                    break;
                }
                case ('U'):
                {
                    addColor(ColorEnum.BLUE);
                    level++;
                    break;
                }
                case ('N'):
                {
                    level++;
                    break;
                }
                case ('9'): level++;
                case ('8'): level++;
                case ('7'): level++;
                case ('6'): level++;
                case ('5'): level++;
                case ('4'): level++;
                case ('3'): level++;
                case ('2'): level++;
                case ('1'): level++;
            }
        }
        this.level = level;
    }

    private void setRaces(String racesString)
    {
        String stringPiece = "";
        int i = 0;
        while (i < racesString.length())
        {
            if (racesString.charAt(i) != ' ') stringPiece += racesString.charAt(i);
            if (i + 1 == racesString.length() || racesString.charAt(i + 1) == ' ')
            {
                for (RaceEnum race : RaceEnum.values())
                {
                    if (race.name().equalsIgnoreCase(stringPiece))
                    {
                        races.add(race);
                    }
                }
                stringPiece = "";
            }
            i++;
        }
    }

    private SuitEnum setSuit()
    {
        if (attribute == AttributeEnum.MAGIC) return SuitEnum.MAGIC;
        if (attribute == AttributeEnum.TRAP) return SuitEnum.TRAP;
        if (abilities.size() == 1) return SuitEnum.NORMAL;
        if (abilities.size() == 3) return SuitEnum.EFFECT;
        if (abilities.size() == 5) return SuitEnum.FUSION;
        if (abilities.size() == 7) return SuitEnum.RITUAL;
        if (abilities.size() == 9) return SuitEnum.RED;
        if (abilities.size() == 11) return SuitEnum.YELLOW;
        System.out.println("setSuit()--error");
        return null;
    }

    private void addColor(ColorEnum color)
    {
        colors.add(color);
    }

    // gay means happy :)
    public Card(String name, AttributeEnum attribute, String races, String cost,
                Ability ability1, Ability ability2, Ability ability3,
                Ability ability4, Ability ability5, Ability ability6,
                Ability ability7, Ability ability8, Ability ability9,
                Ability ability10, Ability ability11, int size)
    {
        this(name, attribute, cost);
        this.races = new HashSet<>();
        this.abilities = new HashSet<>();
        abilities.add(ability1); abilities.add(ability2); abilities.add(ability3);
        abilities.add(ability4); abilities.add(ability5); abilities.add(ability6);
        abilities.add(ability7); abilities.add(ability8); abilities.add(ability9);
        abilities.add(ability10); abilities.add(ability11);
        this.size = size;
        setLevel();
        setRaces(races);
        suit = setSuit();
        this.superTypes = new HashSet<>();
        this.superTypes.add(SuperTypeEnum.CREATURE);
    }
}
