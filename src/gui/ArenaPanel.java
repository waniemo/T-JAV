package gui;

import Team.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class ArenaPanel extends JPanel {
    private Image backgroundImage;
    private PvBar playerPvBar;
    private PvBar enemyPvBar;
    private Timer gameLoopTimer;

    public ArenaPanel(App frame, Team playerTeam, Team enemyTeam) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/battle_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());

            GridBagConstraints gbcLeft = LayoutHelper.createGridBagConstraints(0, 1, 0.5, 1.0);
            GridBagConstraints gbcRight = LayoutHelper.createGridBagConstraints(1, 0, 0.5, 1.0);

            JLabel textBoxLabel = new TextBox(
                    "QUE DOIT FAIRE " + playerTeam.getActivePokemon().getName().toUpperCase() + " ?");

            JPanel playerTeamPanel = PanelHelper.createTeamPanel(frame, playerTeam);
            JPanel enemyTeamPanel = PanelHelper.createTeamPanel(frame, enemyTeam);

            for (Component component : playerTeamPanel.getComponents()) {
                if (component instanceof PvBar) {
                    playerPvBar = (PvBar) component;
                }
            }
            for (Component component : enemyTeamPanel.getComponents()) {
                if (component instanceof PvBar) {
                    enemyPvBar = (PvBar) component;
                }
            }

            // Top left panel
            add(enemyTeamPanel, gbcLeft);

            // Bottom right panel
            gbcRight.gridx = 1;
            gbcRight.gridy = 4;
            gbcRight.weightx = 0;
            gbcRight.weighty = 0;
            add(playerTeamPanel, gbcRight);

            // Text box
            gbcRight.gridx = 1;
            gbcRight.gridy = 5;
            gbcRight.weighty = 0;
            gbcRight.weightx = 0;
            add(textBoxLabel, gbcRight);

            // Bottom left panel with 3 buttons
            gbcLeft.gridx = 0;
            gbcLeft.gridy = 5;
            gbcLeft.weighty = 0;
            JPanel buttonPanel = PanelHelper.createButtonPanel(frame, this, playerTeam, enemyTeam);
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

            gameLoopTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update the state of the game here
                    // For example:
                    // playerTeam.getActivePokemon().update();
                    // enemyTeam.getActivePokemon().update();

                    // Repaint the panel to reflect the changes
                    repaint();
                }
            });
            gameLoopTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }

    public PvBar getPlayerPvBar() {
        return playerPvBar;
    }

    public PvBar getEnemyPvBar() {
        return enemyPvBar;
    }
}
