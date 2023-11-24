package gui;

import Team.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import Pokemon.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ArenaPanel extends JPanel {
    private Image backgroundImage;
    private PvBar playerPvBar;
    private PvBar enemyPvBar;
    private Timer gameLoopTimer;
    private JPanel playerTeamPanel;
    private JPanel enemyTeamPanel;
    private TextBox textBoxLabel;
    private JPanel playerPokemonLeft;
    private JPanel enemyPokemonLeft;
    private JPanel enemyPanel;
    private JPanel playerPanel;
    private PlaySprite playerPlaySprite;
    private PlaySprite enemyPlaySprite;

    private BufferedImage playerCurrentSprite;
    private BufferedImage enemyCurrentSprite;

    public ArenaPanel(App frame, Team playerTeam, Team enemyTeam, PlaySound sound) {
        try {
            InputStream imageStream = ArenaPanel.class.getClassLoader().getResourceAsStream("Assets/Background/battle_bg.png");
            backgroundImage = ImageIO.read(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());

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
        LayoutHelper.modifyGridBagConstraints(gbc, 1, 4, 0, 0);
        playerPanel.add(playerPokemonLeft);
        playerPanel.add(playerTeamPanel);
        add(playerPanel, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 0, 3, 0, 3);
        add(Box.createVerticalGlue(), gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 1, 2, 0, 3);
        add(Box.createVerticalGlue(), gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 1, 5, 0, 0);
        add(textBoxLabel, gbc);

        LayoutHelper.modifyGridBagConstraints(gbc, 0, 5, 0, 0);
        JPanel buttonPanel = PanelHelper.createButtonPanel(frame, this, playerTeam, enemyTeam);
        add(buttonPanel, gbc);


        // enemyPlaySprite = new PlaySprite("Assets/AnimatedSprites/bulbizare_f.png", 40, 38, 11);
        enemyPlaySprite = new PlaySprite("Assets/" + enemyTeam.getActivePokemon().getSpriteFront(), enemyTeam.getActivePokemon().getSpriteWidthFront(), enemyTeam.getActivePokemon().getSpriteHeight(), enemyTeam.getActivePokemon().getSpriteCount());
        enemyCurrentSprite = enemyPlaySprite.getNextSprite();
        // playerPlaySprite = new PlaySprite("Assets/AnimatedSprites/kirby_b.png", 35, 31, 16);
        playerPlaySprite = new PlaySprite("Assets/" + playerTeam.getActivePokemon().getSpriteBack(), playerTeam.getActivePokemon().getSpriteWidthBack(), playerTeam.getActivePokemon().getSpriteHeight(), playerTeam.getActivePokemon().getSpriteCount());
        playerCurrentSprite = enemyPlaySprite.getNextSprite();

        gameLoopTimer = new Timer(50, new ActionListener() {
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
                enemyCurrentSprite = enemyPlaySprite.getNextSprite();
                playerCurrentSprite = playerPlaySprite.getNextSprite();
                repaint();
            }

            private void updatePokemon(Team team, Pokemon lastPokemon, GridBagConstraints gbc, boolean isPlayer) {
                if (playerTeam.getActivePokemon() != lastPlayerPokemon) {
                    remove(textBoxLabel);
                    playerPanel.removeAll();
                    remove(playerPanel);
                    // playerPlaySprite = new PlaySprite("Assets/AnimatedSprites/kirby_b.png", 36.3, 31, 16);
                    playerPlaySprite = new PlaySprite("Assets/" + playerTeam.getActivePokemon().getSpriteBack(), playerTeam.getActivePokemon().getSpriteWidthBack(), playerTeam.getActivePokemon().getSpriteHeight(), playerTeam.getActivePokemon().getSpriteCount());
                    lastPlayerPokemon = playerTeam.getActivePokemon();
                    playerTeamPanel = PanelHelper.createTeamPanel(frame, playerTeam);
                    for (Component component : playerTeamPanel.getComponents()) {
                        if (component instanceof PvBar) {
                            playerPvBar = (PvBar) component;
                        }
                    }
                    textBoxLabel = new TextBox(
                            "QUE DOIT FAIRE " + playerTeam.getActivePokemon().getName().toUpperCase() + "?");

                    LayoutHelper.modifyGridBagConstraints(gbc, 1, 5, 0, 0);
                    add(textBoxLabel, gbc);

                    LayoutHelper.modifyGridBagConstraints(gbc, 1, 4, 0, 0);
                    playerPanel.add(playerPokemonLeft);
                    playerPanel.add(playerTeamPanel);
                    add(playerPanel, gbc);
                }
                if (enemyTeam.getActivePokemon() != lastEnemyPokemon) {
                    enemyPanel.removeAll();
                    remove(enemyPanel);
                    enemyTeamPanel = PanelHelper.createTeamPanel(frame, enemyTeam);
                    for (Component component : enemyTeamPanel.getComponents()) {
                        if (component instanceof PvBar) {
                            enemyPvBar = (PvBar) component;
                        }
                    }
                    // enemyPlaySprite = new PlaySprite("Assets/AnimatedSprites/bulbizare_f.png", 39, 45, 21);
                    enemyPlaySprite = new PlaySprite("Assets/" + enemyTeam.getActivePokemon().getSpriteFront(), enemyTeam.getActivePokemon().getSpriteWidthFront(), enemyTeam.getActivePokemon().getSpriteHeight(), enemyTeam.getActivePokemon().getSpriteCount());
                    enemyCurrentSprite = enemyPlaySprite.getNextSprite();
                    lastEnemyPokemon = enemyTeam.getActivePokemon();
                    LayoutHelper.modifyGridBagConstraints(gbc, 0, 0, 0.5, 1.0);
                    enemyPanel.add(enemyTeamPanel);
                    enemyPanel.add(enemyPokemonLeft);
                    add(enemyPanel, gbc);

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
                        gameLoopTimer.stop(); // todo
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
        Image sPlayerSprite = playerCurrentSprite.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        Image sEnemySprite = enemyCurrentSprite.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
        g.drawImage(sEnemySprite, 800, 250, this);
        g.drawImage(sPlayerSprite, 250, 400, this);
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
