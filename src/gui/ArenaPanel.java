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
        GridBagConstraints gbcLeft = LayoutHelper.createGridBagConstraints(0, 0, 0.5, 1.0);
        GridBagConstraints gbcRight = LayoutHelper.createGridBagConstraints(1, 0, 0.5, 1.0);

        JPanel playerTeamPanel = PanelHelper.createTeamPanel(playerTeam);
        JPanel enemyTeamPanel = PanelHelper.createTeamPanel(enemyTeam);

        // Top left panel
        add(playerTeamPanel, gbcLeft);

        // Bottom right panel
        gbcRight.gridx = 1;
        gbcRight.gridy = 3;
        gbcRight.weightx = 0.5;
        add(enemyTeamPanel, gbcRight);

        // Bottom left panel with 3 buttons
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 3;
        JPanel buttonPanel = PanelHelper.createButtonPanel();
        add(buttonPanel, gbcLeft);

        // Player Pokemon
        gbcRight.weighty = 3.5;
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 2;
        add(IconHelper.createTeamIcon(playerTeam, true), gbcLeft);

        // Enemy pokemon
        gbcRight.weighty = 3;
        gbcRight.insets = new Insets(80, 0, 0, 0); // Add 20 pixels of padding on top
        gbcRight.gridx = 1;
        gbcRight.gridy = 1;
        add(IconHelper.createTeamIcon(enemyTeam, false), gbcRight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}
