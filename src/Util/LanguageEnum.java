package Util;

/**
 * Created by Robin on 2/28/2017.
 */
public enum LanguageEnum
{
    ENGLISH { public String toString() { return "English"; } },
    SPANISH { public String toString() { return "Español"; } },
    ITALIAN { public String toString() { return "Italiano"; } },
    FRENCH { public String toString() { return "Français"; } },
    GERMAN { public String toString() { return "Deutsche"; } },
    WAPANESE { public String toString() { return "日本語"; } };

    public String toString()
    {
        return "Error";
    }
}
