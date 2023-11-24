package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImagePanel extends JPanel {
    public ImagePanel(String imagePath, int width, int height) {
        BufferedImage img = null;
        try {
            InputStream imageStream = ArenaPanel.class.getClassLoader().getResourceAsStream(imagePath);
            img = ImageIO.read(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        JLabel label = new JLabel(imageIcon);
        add(label);
    }
}