package gui;

import Team.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import Pokemon.Kirby;
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
    private JPanel playerPokemonLeft;
    private JPanel enemyPokemonLeft;
    private JPanel enemyPanel;
    private JPanel playerPanel;

    public ArenaPanel(App frame, Team playerTeam, Team enemyTeam, PlaySound sound) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/Background/battle_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        playerSprite = IconHelper.createTeamIcon(playerTeam, true);
        enemySprite = IconHelper.createTeamIcon(enemyTeam, false);

        textBoxLabel = new TextBox("QUE DOIT FAIRE " + playerTeam.getActivePokemon().getName().toUpperCase() + " ?");

        enemyPanel = new JPanel(new GridLayout(2, 1));
        playerPanel = new JPanel(new GridLayout(2, 1));
        playerTeamPanel = PanelHelper.createTeamPanel(frame, playerTeam);
        enemyTeamPanel = PanelHelper.createTeamPanel(frame, enemyTeam);
        playerPokemonLeft = PanelHelper.createPokeballPanel(frame, playerTeam);
        enemyPokemonLeft = PanelHelper.createPokeballPanel(frame, enemyTeam);
        enemyPanel.setOpaque(false);
        playerPanel.setOpaque(false);
        playerPokemonLeft.setOpaque(false);
        enemyPokemonLeft.setOpaque(false);

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

        enemyPanel.add(enemyTeamPanel);
        enemyPanel.add(enemyPokemonLeft, gbc);
        add(enemyPanel, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 1, 2, 0, 3);
        add(enemySprite, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 0, 3, 0, 3);
        add(playerSprite, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 1, 4, 0, 0);
        playerPanel.add(playerPokemonLeft);
        playerPanel.add(playerTeamPanel);
        add(playerPanel, gbc);

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
                    playerPanel.removeAll();
                    remove(playerPanel);
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
                    playerPanel.add(playerPokemonLeft);
                    playerPanel.add(playerTeamPanel);
                    add(playerPanel, gbc);
                }
                if (enemyTeam.getActivePokemon() != lastEnemyPokemon) {
                    remove(enemySprite);
                    enemyPanel.removeAll();
                    remove(enemyPanel);
                    enemyTeamPanel = PanelHelper.createTeamPanel(frame, enemyTeam);
                    for (Component component : enemyTeamPanel.getComponents()) {
                        if (component instanceof PvBar) {
                            enemyPvBar = (PvBar) component;
                        }
                    }
                    enemySprite = IconHelper.createTeamIcon(enemyTeam, false);
                    lastEnemyPokemon = enemyTeam.getActivePokemon();
                    LayoutHelper.modifyGridBagConstraints(gbc, 0, 0, 0.5, 1.0);
                    enemyPanel.add(enemyTeamPanel);
                    enemyPanel.add(enemyPokemonLeft);
                    add(enemyPanel, gbc);

                    LayoutHelper.modifyGridBagConstraints(gbc, 1, 2, 0, 3);
                    add(enemySprite, gbc);
                    revalidate();
                    repaint();
                }
            }

            private void checkPokemonKO(Team team, App frame, boolean isPlayer) {
                if (team.getActivePokemon().getPv() <= 0 && !team.getDeadPokemons().contains(team.getActivePokemon())) {
                    if (team.getDeadPokemons().size() < 5) {
                        if (isPlayer) {
                            team.addDeadPokemon(team.getActivePokemon());
                            playerPokemonLeft = PanelHelper.createPokeballPanel(frame, team);
                            playerPokemonLeft.setOpaque(false);
                            frame.getContentPane().removeAll();
                            frame.getContentPane()
                                    .add(new ChangePokemon((App) frame, ArenaPanel.this, playerTeam, enemyTeam));
                            frame.revalidate();
                            frame.repaint();
                        } else {
                            setTextBoxLabel(team.getActivePokemon().getName() + " est KO !");
                            team.addDeadPokemon(team.getActivePokemon());
                            enemyPokemonLeft = PanelHelper.createPokeballPanel(frame, team);
                            enemyPokemonLeft.setOpaque(false);
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
                            sound.stopSound();
                            team.addDeadPokemon(team.getActivePokemon());
                            frame.getContentPane().removeAll();
                            frame.getContentPane()
                                    .add(new EndOfGame((App) frame, false));
                            frame.revalidate();
                            frame.repaint();
                        } else {
                            sound.stopSound();
                            team.addDeadPokemon(team.getActivePokemon());
                            frame.getContentPane().removeAll();
                            frame.getContentPane()
                                    .add(new EndOfGame((App) frame, true));
                            frame.revalidate();
                            frame.repaint();
                        }
                        // gameLoopTimer.stop(); // todo
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
