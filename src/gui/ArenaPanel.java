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
    private TextBox textBoxLabel;

    public ArenaPanel(App frame, Team playerTeam, Team enemyTeam) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/Background/battle_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        playerSprite = IconHelper.createTeamIcon(playerTeam, true);
        enemySprite = IconHelper.createTeamIcon(enemyTeam, false);

        textBoxLabel = new TextBox("QUE DOIT FAIRE " + playerTeam.getActivePokemon().getName().toUpperCase() + " ?");

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

        GridBagConstraints gbc = LayoutHelper.createGridBagConstraints(0, 0, 0.5, 1.0);

        add(enemyTeamPanel, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 1, 2, 0, 3);
        add(enemySprite, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 0, 3, 0, 3);
        add(playerSprite, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 1, 4, 0, 0);
        add(playerTeamPanel, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 1, 5, 0, 0);
        add(textBoxLabel, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 0, 5, 0, 0);
        JPanel buttonPanel = PanelHelper.createButtonPanel(frame, this, playerTeam, enemyTeam);
        add(buttonPanel, gbc);

        gameLoopTimer = new Timer(16, new ActionListener() {
            private Pokemon lastPlayerPokemon = playerTeam.getActivePokemon();
            private Pokemon lastEnemyPokemon = enemyTeam.getActivePokemon();

            @Override
            public void actionPerformed(ActionEvent e) {
                updatePokemon(playerTeam, lastPlayerPokemon, gbc, true);
                updatePokemon(enemyTeam, lastEnemyPokemon, gbc, false);

                checkPokemonKO(playerTeam, frame, true);
                checkPokemonKO(enemyTeam, frame, false);

                getPlayerPvBar().updateBar(frame.isAnimated()); // animation
                getEnemyPvBar().updateBar(frame.isAnimated()); // animation
                repaint();
            }

            private void updatePokemon(Team team, Pokemon lastPokemon, GridBagConstraints gbc, boolean isPlayer) {
                if (playerTeam.getActivePokemon() != lastPlayerPokemon) {
                    remove(playerSprite);
                    remove(textBoxLabel);
                    remove(playerTeamPanel);
                    playerSprite = IconHelper.createTeamIcon(playerTeam, true);
                    lastPlayerPokemon = playerTeam.getActivePokemon();
                    playerTeamPanel = PanelHelper.createTeamPanel(frame, playerTeam);
                    for (Component component : playerTeamPanel.getComponents()) {
                        if (component instanceof PvBar) {
                            playerPvBar = (PvBar) component;
                        }
                    }
                    textBoxLabel = new TextBox(
                            "QUE DOIT FAIRE " + playerTeam.getActivePokemon().getName().toUpperCase() + "?");
                    LayoutHelper.modifyGridBagConstraints(gbc, 0, 3, 0, 3);
                    add(playerSprite, gbc);

                    LayoutHelper.modifyGridBagConstraints(gbc, 1, 5, 0, 0);
                    add(textBoxLabel, gbc);

                    LayoutHelper.modifyGridBagConstraints(gbc, 1, 4, 0, 0);
                    add(playerTeamPanel, gbc);
                }
                if (enemyTeam.getActivePokemon() != lastEnemyPokemon) {
                    remove(enemySprite);
                    remove(enemyTeamPanel);
                    enemyTeamPanel = PanelHelper.createTeamPanel(frame, enemyTeam);
                    for (Component component : enemyTeamPanel.getComponents()) {
                        if (component instanceof PvBar) {
                            enemyPvBar = (PvBar) component;
                        }
                    }
                    enemySprite = IconHelper.createTeamIcon(enemyTeam, false);
                    lastEnemyPokemon = enemyTeam.getActivePokemon();
                    LayoutHelper.modifyGridBagConstraints(gbc, 0, 0, 0.5, 1.0);
                    add(enemyTeamPanel, gbc);

                    LayoutHelper.modifyGridBagConstraints(gbc, 1, 2, 0, 3);
                    add(enemySprite, gbc);
                }
            }

            private void checkPokemonKO(Team team, App frame, boolean isPlayer) {
                if (team.getActivePokemon().getPv() <= 0 && !team.getDeadPokemons().contains(team.getActivePokemon())) {
                    setTextBoxLabel(team.getActivePokemon().getName() + " est KO !");
                    team.addDeadPokemon(team.getActivePokemon());

                    if (team.getDeadPokemons().size() < 6) {
                        if (isPlayer) {
                            frame.getContentPane().removeAll();
                            frame.getContentPane()
                                    .add(new ChangePokemon((App) frame, ArenaPanel.this, playerTeam, enemyTeam));
                            frame.revalidate();
                            frame.repaint();
                        } else {
                            setTextBoxLabel(team.getActivePokemon().getName() + " est KO !");
                            team.addDeadPokemon(team.getActivePokemon());
                            for (int i = 0; i < team.getTeam().size(); i++) {
                                if (!team.getDeadPokemons().contains(team.getTeam().get(i))) {
                                    team.setActivePokemon(team.getTeam().get(i));
                                    setTextBoxLabel("L'ennemi envoie " + team.getActivePokemon().getName() + "!");
                                    break;
                                }
                            }
                        }
                    } else {
                        if (isPlayer) {
                            setTextBoxLabel("Vous avez perdu !");
                        } else {
                            setTextBoxLabel("Vous avez gagné !");
                        }
                        gameLoopTimer.stop();
                    }
                }
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

    public JLabel getTextBoxLabel() {
        return textBoxLabel;
    }

    public void setTextBoxLabel(String textBoxLabel) {
        this.textBoxLabel.updateText(textBoxLabel, false);
    }
}
