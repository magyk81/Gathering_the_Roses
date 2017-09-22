package Util;

/**
 * Created by Robin on 2/28/2017.
 */
public enum LanguageEnum
{
    ENGLISH
            {
                public String toString() { return "English"; }
                public int getID() { return 0; }
            },
    SPANISH
            {
                public String toString() { return "Español"; }
                public int getID() { return 1; }
            },
    ITALIAN
            {
                public String toString() { return "Italiano"; }
                public int getID() { return 2; }
            },
    FRENCH
            {
                public String toString() { return "Français"; }
                public int getID() { return 3; }
            },
    GERMAN
            {
                public String toString() { return "Deutsche"; }
                public int getID() { return 4; }
            },
    WAPANESE
            {
                public String toString() { return "日本語"; }
                public int getID() { return 5; }
            };

    public String toString()
    {
        return "Error";
    }
    public int getID() { return -1; }
}
