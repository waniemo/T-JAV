package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.IOException;

public class EndOfGame extends JPanel {
    private Image backgroundImage;
    private TextBox itemDescription = new TextBox("");
    private static PlaySound sound = new PlaySound();

    public EndOfGame(App frame, boolean win) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/Background/menu2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = LayoutHelper.createGridBagConstraints(0, 0, 0, 0);

        sound.stopSound();

        if (win) {
            itemDescription = new TextBox("Félicitation! Vous avez gagné !");
            sound.playSound("win", frame.hasSound());
        } else {
            itemDescription = new TextBox("Vous avez perdu . . .");
            sound.playSound("lost", frame.hasSound());
        }

        add(itemDescription, gbc);

        JButton quitButton = new JButton("QUITTER");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        gbc.gridy = 1;
        add(quitButton, gbc);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}
