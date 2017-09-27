package Common;

import Util.DirectionEnum;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by Robin on 4/6/2017.
 */
public class Keyboard implements EventHandler<KeyEvent>
{
    private UserView userView;

    public void assignUserView(UserView userView) { this.userView = userView;}

    @Override
    public void handle(KeyEvent event)
    {
        if (event.getCode() == KeyCode.A) System.out.println(KeyCode.A.toString());

        if (event.getCode() == KeyCode.T)
        {
            if (event.getEventType() == KeyEvent.KEY_PRESSED) System.out.println("testing1");
            if (event.getEventType() == KeyEvent.KEY_RELEASED) System.out.println("testing2");
        }

        if (event.getEventType() == KeyEvent.KEY_PRESSED)
        {
            if (event.getCode() == KeyCode.LEFT)
            {
                userView.pan(DirectionEnum.WEST);
            }
            else if (event.getCode() == KeyCode.RIGHT)
            {
                userView.pan(DirectionEnum.EAST);
            }
            else if (event.getCode() == KeyCode.UP)
            {
                userView.pan(DirectionEnum.NORTH);
            }
            else if (event.getCode() == KeyCode.DOWN)
            {
                userView.pan(DirectionEnum.SOUTH);
            }
            else if (event.getCode() == KeyCode.COMMA)
            {
                userView.zoom(true);
            }
            else if (event.getCode() == KeyCode.PERIOD)
            {
                userView.zoom(false);
            }
        }
    }
}
