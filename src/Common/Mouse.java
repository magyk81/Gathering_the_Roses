package Common;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import static javafx.scene.input.MouseEvent.*;

/**
 * Created by Robin on 12/21/2016.
 */
public class Mouse implements EventHandler<MouseEvent>
{
    private Match match;
    private UserView userView;

    public void assignMatch(Match match) { this.match = match; }
    public void assignUserView(UserView userView) { this.userView = userView; }

    @Override
    public void handle(MouseEvent event)
    {
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (event.getEventType() == MOUSE_DRAGGED)
        {
            match.continueTrail(x, y);
            userView.continueSelecting(x, y);
        }

        if (event.getButton() == MouseButton.SECONDARY)
        {
            if (event.getEventType() == MOUSE_PRESSED) match.startTrail(x, y);
            else if (event.getEventType() == MOUSE_RELEASED) match.finishTrail(x, y);
        }
        if (event.getButton() == MouseButton.MIDDLE)
        {
            if (event.getEventType() == MOUSE_PRESSED) userView.startSelecting(x, y);
            else if (event.getEventType() == MOUSE_RELEASED) userView.finishSelecting(x, y);
        }
        if (event.getButton() == MouseButton.PRIMARY)
        {
            //if (event.getEventType() == MOUSE_CLICKED) match.spawnLand(x, y);
        }
    }
}
