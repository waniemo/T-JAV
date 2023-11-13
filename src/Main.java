import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import gui.*;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class Main {

    public static void setUIFont(FontUIResource f) {
    Enumeration<Object> keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
        Object key = keys.nextElement();
        Object value = UIManager.get(key);
        if (value instanceof FontUIResource) {
            UIManager.put(key, f);
        }
    }
}


    public static void main(String[] args) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("../Assets/Fonts/pokemon-ds-font.otf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        FontUIResource f = new FontUIResource(font.deriveFont(20f));
        setUIFont(f);
        App app = new App();
        app.setVisible(true);
    }
}
