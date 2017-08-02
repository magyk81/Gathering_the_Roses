package Common;

import Abilities.Ability;
import Abilities.AbilityEnum;
import Trait.AttributeEnum;

import java.util.HashSet;

/**
 * Created by Robin on 4/10/2017.
 */
public class Player
{
    private String name;

    private UserView userView;
    private Board board;

    private HashSet<Creature> selectedPermanents;

    Player(String name)
    {
        this.name = name;

        selectedPermanents = new HashSet<>();
    }

    public void start(UserView userView, Board board)
    {
        this.userView = userView;
        this.board = board;
    }

    public String getName() { return name; }

    public void selectPermanents(HashSet<Creature> permanents)
    {
        for (Creature perm : permanents)
        {
            selectedPermanents.add(perm);
            perm.changeColor(false);
        }
    }

    /**
     * For testing
     */
    public void test()
    {
        /**************************************************/

        Card testCard = new Card(
                "Dank Magician",
                AttributeEnum.DARK,
                "human wizard",
                "6B",
                new Ability(AbilityEnum.Wither),
                2500,
                2100,
                5);

        board.spawnPermanent(testCard, userView.getHighlightedLand(), 100, 100);

        /**************************************************/
    }
}
