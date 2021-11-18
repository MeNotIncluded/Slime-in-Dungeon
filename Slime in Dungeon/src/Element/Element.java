package Element;

import java.awt.*;
import java.io.File;

public class Element
{

    public static Font getFont(int size)
    {
        Font font = null;
        try
        {
            font = Font.createFont(Font.TRUETYPE_FONT,new File("font\\lookpeach.ttf"));
            return font.deriveFont((float)size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return font;
    }
}