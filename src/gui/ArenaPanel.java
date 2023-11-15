package gui;

import Team.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import Pokemon.Pokemon;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class ArenaPanel extends JPanel {
    private Image backgroundImage;
    private PvBar playerPvBar;
    private PvBar enemyPvBar;
    private Timer gameLoopTimer;
    private JLabel playerSprite;
    private JLabel enemySprite;
    private JPanel playerTeamPanel;
    private JPanel enemyTeamPanel;
    JLabel textBoxLabel;

    public ArenaPanel(App frame, Team playerTeam, Team enemyTeam) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/battle_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        playerSprite = IconHelper.createTeamIcon(playerTeam, true);
        enemySprite = IconHelper.createTeamIcon(enemyTeam, false);

        GridBagConstraints gbcLeft = LayoutHelper.createGridBagConstraints(0, 1, 0.5, 1.0);
        GridBagConstraints gbcRight = LayoutHelper.createGridBagConstraints(1, 0, 0.5, 1.0);

        textBoxLabel = new TextBox(
                "QUE DOIT FAIRE " + playerTeam.getActivePokemon().getName().toUpperCase() + " ?");

        playerTeamPanel = PanelHelper.createTeamPanel(frame, playerTeam);
        enemyTeamPanel = PanelHelper.createTeamPanel(frame, enemyTeam);

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
        add(playerSprite, gbcLeft);

        // Enemy pokemon
        gbcRight.weighty = 3;
        gbcRight.insets = new Insets(80, 0, 0, 0); // Add 20 pixels of padding on top
        gbcRight.gridx = 1;
        gbcRight.gridy = 2;
        add(enemySprite, gbcRight);

        gameLoopTimer = new Timer(150, new ActionListener() {
            private Pokemon lastPlayerPokemon = playerTeam.getActivePokemon();
            private Pokemon lastEnemyPokemon = enemyTeam.getActivePokemon();

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game updated!");

                if (playerTeam.getActivePokemon() != lastPlayerPokemon) {
                    remove(playerSprite);
                    remove(textBoxLabel);
                    remove(playerTeamPanel);
                    gbcLeft.weighty = 3.5;
                    gbcLeft.gridx = 0;
                    gbcLeft.gridy = 3;
                    playerSprite = IconHelper.createTeamIcon(playerTeam, true);
                    lastPlayerPokemon = playerTeam.getActivePokemon();
                    playerTeamPanel = PanelHelper.createTeamPanel(frame, playerTeam);
                    for (Component component : playerTeamPanel.getComponents()) {
                        if (component instanceof PvBar) {
                            playerPvBar = (PvBar) component;
                        }
                    }
                    textBoxLabel = new TextBox(
                            "QUE DOIT FAIRE " + playerTeam.getActivePokemon().getName().toUpperCase() + " ?");
                    add(playerSprite, gbcLeft);
                    gbcRight.gridx = 1;
                    gbcRight.gridy = 5;
                    gbcRight.weighty = 0;
                    gbcRight.weightx = 0;
                    add(textBoxLabel, gbcRight);
                    gbcRight.gridx = 1;
                    gbcRight.gridy = 4;
                    gbcRight.weightx = 0;
                    gbcRight.weighty = 0;
                    add(playerTeamPanel, gbcRight);
                }
                if (enemyTeam.getActivePokemon() != lastEnemyPokemon) {
                    remove(enemySprite);
                    remove(enemyTeamPanel);
                    gbcLeft.gridx = 0;
                    gbcLeft.gridy = 0;
                    gbcLeft.weightx = 0;
                    gbcLeft.weighty = 0;
                    enemyTeamPanel = PanelHelper.createTeamPanel(frame, enemyTeam);
                    for (Component component : enemyTeamPanel.getComponents()) {
                        if (component instanceof PvBar) {
                            enemyPvBar = (PvBar) component;
                        }
                    }
                    add(enemyTeamPanel, gbcLeft);
                    gbcRight.weighty = 3;
                    gbcRight.insets = new Insets(80, 0, 0, 0); // Add 20 pixels of padding on top
                    gbcRight.gridx = 1;
                    gbcRight.gridy = 2;
                    enemySprite = IconHelper.createTeamIcon(enemyTeam, false);
                    lastEnemyPokemon = enemyTeam.getActivePokemon();
                    add(enemySprite, gbcRight);
                }
                getPlayerPvBar().updateBar();
                getEnemyPvBar().updateBar();
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
