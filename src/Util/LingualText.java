package Util;

import Menus.Main;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by Robin on 9/19/2017.
 */
public class LingualText extends Text
{
    String[] strings;

    LingualText(String[] strings, Font font)
    {
        setText(strings);
        setFont(font);
    }

    void setText(String[] strings)
    {
        this.strings = strings;
        setText();
    }

    public String toString()
    {
        return strings[Main.language.getID()];
    }

    private void setText()
    {
        setText(strings[Main.language.getID()]);
    }
}
