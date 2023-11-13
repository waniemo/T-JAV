package gui;

import Team.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ArenaPanel extends JPanel {
    private Image backgroundImage;

    public ArenaPanel(App frame, Team playerTeam, Team enemyTeam) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/battle_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbcLeft = LayoutHelper.createGridBagConstraints(0, 1, 0.5, 1.0);
        GridBagConstraints gbcRight = LayoutHelper.createGridBagConstraints(1, 0, 0.5, 1.0);

        JPanel playerTeamPanel = PanelHelper.createTeamPanel(playerTeam);
        JPanel enemyTeamPanel = PanelHelper.createTeamPanel(enemyTeam);

        // Top left panel
        gbcLeft.insets = new Insets(30, 0, 0, 0);
        add(enemyTeamPanel, gbcLeft);

        // Bottom right panel
        gbcRight.gridx = 1;
        gbcRight.gridy = 4;
        gbcRight.weightx = 0.5;
        gbcRight.weighty = 0.1;
        add(playerTeamPanel, gbcRight);

        // Bottom left panel with 3 buttons
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 5;
        JPanel buttonPanel = PanelHelper.createButtonPanel(frame, playerTeam, enemyTeam);
        add(buttonPanel, gbcLeft);

        // Player Pokemon
        gbcLeft.weighty = 3.5;
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 3;
        add(IconHelper.createTeamIcon(playerTeam, true), gbcLeft);

        // Enemy pokemon
        gbcRight.weighty = 3;
        gbcRight.insets = new Insets(80, 0, 0, 0); // Add 20 pixels of padding on top
        gbcRight.gridx = 1;
        gbcRight.gridy = 2;
        add(IconHelper.createTeamIcon(enemyTeam, false), gbcRight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}
