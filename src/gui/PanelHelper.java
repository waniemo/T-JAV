package gui;

import Team.*;
import Type.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelHelper {
    private static PlaySound sound = new PlaySound();
    private static ImageIcon attaqueIcon = null;
    private static ImageIcon pokemonIcon = null;
    private static ImageIcon sacIcon = null;

    public static JPanel createTeamPanel(App frame, Team team) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel(team.getActivePokemon().getName());
        JLabel levelLabel = new JLabel("Niveau " + team.getActivePokemon().getLevel());
        JLabel typeLabel = new JLabel(team.getActivePokemon().getType().toString());
        panel.setBackground(Color.LIGHT_GRAY);

        nameLabel.setFont(UIManager.getFont("Label.font").deriveFont(40f));
        levelLabel.setFont(UIManager.getFont("Label.font").deriveFont(30f));
        typeLabel.setIcon(new ImageIcon("Assets/Type/feu.png"));

        PvBar pvBar = new PvBar(team.getActivePokemon());
        pvBar.updateBar(false); // animation
        nameLabel.setBorder(new EmptyBorder(0, 20, 0, 20));
        levelLabel.setBorder(new EmptyBorder(0, 20, 0, 20));
        panel.add(nameLabel, BorderLayout.WEST);
        panel.add(levelLabel, BorderLayout.EAST);
        panel.add(pvBar, BorderLayout.SOUTH);

        panel.setPreferredSize(new Dimension(150, 50));
        return panel;
    }

    public static JPanel createButtonPanel(App frame, ArenaPanel arena, Team playerTeam, Team enemyTeam) {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setPreferredSize(new Dimension(600, 96));
        buttonPanel.setOpaque(false);
        GridBagConstraints buttonGbc = new GridBagConstraints();

        java.net.URL attaqueURL = ChooseTeamUI.class.getClassLoader().getResource("Assets/Bouton/bouton_attaque.png");
        java.net.URL pokemonURL = ChooseTeamUI.class.getClassLoader().getResource("Assets/Bouton/bouton_pokemon.png");
        java.net.URL sacURL = ChooseTeamUI.class.getClassLoader().getResource("Assets/Bouton/bouton_sac.png");

        if (attaqueURL != null && pokemonURL != null && sacURL != null) {
            // Create ImageIcon from InputStream
            try (java.io.InputStream stream = attaqueURL.openStream()) {
                attaqueIcon = new ImageIcon(javax.imageio.ImageIO.read(stream));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            try (java.io.InputStream stream = pokemonURL.openStream()) {
                pokemonIcon = new ImageIcon(javax.imageio.ImageIO.read(stream));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            try (java.io.InputStream stream = sacURL.openStream()) {
                sacIcon = new ImageIcon(javax.imageio.ImageIO.read(stream));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Image not found: button");
        }

        // attaqueIcon = new ImageIcon("Assets/Bouton/bouton_attaque.png");
        // ImageIcon pokemonIcon = new ImageIcon("Assets/Bouton/bouton_pokemon.png");
        // ImageIcon sacIcon = new ImageIcon("Assets/Bouton/bouton_sac.png");
        JLabel attaqueLabel = new JLabel(attaqueIcon);
        JLabel pokemonLabel = new JLabel(pokemonIcon);
        JLabel sacLabel = new JLabel(sacIcon);

        buttonGbc.insets = new Insets(0, 5, 0, 5);
        buttonGbc.gridx = 0;
        buttonGbc.gridy = 0;
        buttonPanel.add(attaqueLabel, buttonGbc);

        buttonGbc.insets = new Insets(0, 5, 0, 5);
        buttonGbc.gridx = 1;
        buttonGbc.gridy = 0;
        buttonPanel.add(pokemonLabel, buttonGbc);

        buttonGbc.insets = new Insets(0, 5, 0, 5);
        buttonGbc.gridx = 2;
        buttonGbc.gridy = 0;
        buttonPanel.add(sacLabel, buttonGbc);

        sacLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sound.playSound("button", frame.hasSound());

                frame.setContentPane(new Bag(frame, arena, playerTeam, enemyTeam));
                frame.revalidate();
            }
        });

        pokemonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sound.playSound("button", frame.hasSound());

                frame.setContentPane(new ChangePokemon(frame, arena, playerTeam, enemyTeam));
                frame.revalidate();
            }
        });

        attaqueLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sound.playSound("button", frame.hasSound());

                buttonPanel.removeAll();
                buttonPanel.revalidate();
                buttonPanel.repaint();
                JPanel attackButtons = new AttackButtonPanel(frame, arena, playerTeam, enemyTeam, buttonPanel,
                        buttonGbc);
            }
        });
        return buttonPanel;
    }

    public static JPanel createPokeballPanel(App frame, Team team) {
        ImageIcon grey = new ImageIcon("Assets/grey_ball.png");
        ImageIcon red = new ImageIcon("Assets/red_ball.png");

        java.net.URL greyURL = ChooseTeamUI.class.getClassLoader().getResource("Assets/grey_ball.png");
        java.net.URL redURL = ChooseTeamUI.class.getClassLoader().getResource("Assets/red_ball.png");

        if (greyURL != null) {
            // Create ImageIcon from InputStream
            try (java.io.InputStream stream = greyURL.openStream()) {
                grey = new ImageIcon(javax.imageio.ImageIO.read(stream));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Image not found: text_box.png");
        }

        if (redURL != null) {
            // Create ImageIcon from InputStream
            try (java.io.InputStream stream = redURL.openStream()) {
                red = new ImageIcon(javax.imageio.ImageIO.read(stream));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Image not found: text_box.png");
        }

        JPanel panel = new JPanel(new GridLayout(1, 6));
        for (int i = 0; i < 6 - team.getDeadPokemons().size(); i++) {
            JLabel label = new JLabel("");
            label.setPreferredSize(new Dimension(32, 32));
            label.setIcon(red);
            panel.add(label);
        }
        for (int i = 0; i < team.getDeadPokemons().size(); i++) {
            JLabel label = new JLabel("");
            label.setPreferredSize(new Dimension(32, 32));
            label.setIcon(grey);
            panel.add(label);
        }
        panel.setPreferredSize(new Dimension(192, 32));
        return panel;
    }

}