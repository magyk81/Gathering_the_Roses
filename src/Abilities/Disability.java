package Abilities;

/**
 * Created by Robin on 6/21/2017.
 */
public class Disability extends Ability
{
    private Ability compensation[];

    Disability(AbilityEnum ability, Ability compensation1, Ability compensation2)
    {
        super(ability);
        compensation = new Ability[2];
        compensation[0] = compensation1;
        compensation[1] = compensation2;
    }
}
