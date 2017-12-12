package Trait;

import Util.LingualText;

public class Type
{
    LingualText name;

    Type(LingualText name)
{
    this.name = name;
}

    public String toString()
    {
        return name.toString();
    }
}
