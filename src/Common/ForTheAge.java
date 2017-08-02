package Common;

import javafx.animation.AnimationTimer;

/**
 * Created by Robin on 4/6/2017.
 * If her cock is on the clock, she's too young
 */
public class ForTheAge extends AnimationTimer
{
    private Match match;
    private long prevNow = 0;

    ForTheAge(Match match) { this.match = match; }

    @Override
    public void handle(long now)
    {
        if (now >= prevNow + 1_000_000_000)
        {
            prevNow = now;

            // do this every second
        }
    }
}
