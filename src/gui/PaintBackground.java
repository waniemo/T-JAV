package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PaintBackground extends JPanel {
    private Image backgroundImage;

    public PaintBackground(String imagePath) {
        try {
            InputStream imageStream = ArenaPanel.class.getClassLoader().getResourceAsStream(imagePath);
            backgroundImage = ImageIO.read(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}
