package Trait;

import Util.LingualText;

import java.util.ArrayList;

public class Race extends Type
{
    private ArrayList<Type> types;
    private ArrayList<Type> subtypes;

    Race(LingualText name)
    {
        super(name);
        types = new ArrayList<>();
    }

    void setTypes(Type... types)
    {
        for (Type type : types)
        {
            this.types.add(type);
        }
    }

    void setSubtypes(Type... types)
    {
        for (Type type : types)
        {
            subtypes.add(type);
        }
    }
}
