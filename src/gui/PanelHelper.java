package gui;

import Team.*;
import Type.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelHelper {
    public static JPanel createTeamPanel(App frame, Team team) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel(team.getActivePokemon().getName());
        JLabel levelLabel = new JLabel("Niveau " + team.getActivePokemon().getLevel());
        JLabel typeLabel = new JLabel(team.getActivePokemon().getType().toString());
        panel.setBackground(Color.LIGHT_GRAY);

        nameLabel.setFont(UIManager.getFont("Label.font").deriveFont(40f));
        levelLabel.setFont(UIManager.getFont("Label.font").deriveFont(30f));
        typeLabel.setIcon(new ImageIcon("../Assets/feu.png"));

        PvBar pvBar = new PvBar(team.getActivePokemon());
        pvBar.updateBar();
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
        ImageIcon attaqueIcon = new ImageIcon("../Assets/bouton_attaque.png");
        ImageIcon pokemonIcon = new ImageIcon("../Assets/bouton_pokemon.png");
        ImageIcon sacIcon = new ImageIcon("../Assets/bouton_sac.png");
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
                frame.setContentPane(new Bag(frame, arena, playerTeam, enemyTeam));
                frame.revalidate();
            }
        });

        pokemonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setContentPane(new ChangePokemon(frame, arena, playerTeam, enemyTeam));
                frame.revalidate();
            }
        });

        attaqueLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonPanel.removeAll();
                buttonPanel.revalidate();
                buttonPanel.repaint();
                ImageIcon attaque1 = new ImageIcon("../Assets/normal_attaque.png");
                ImageIcon attaque2 = null;
                ImageIcon attaque3 = null;
                ImageIcon attaque4 = null;
                try {
                    System.out.println(playerTeam.getActivePokemon().getType().getDeclaredConstructor().newInstance().getName().toLowerCase());
                    attaque2 = new ImageIcon("../Assets/"+playerTeam.getActivePokemon().getType().getDeclaredConstructor().newInstance().getName().toLowerCase()+"_attaque.png");
                    attaque3 = new ImageIcon("../Assets/"+playerTeam.getActivePokemon().getType().getDeclaredConstructor().newInstance().getName().toLowerCase()+"_attaque.png");
                    attaque4 = new ImageIcon("../Assets/"+playerTeam.getActivePokemon().getType().getDeclaredConstructor().newInstance().getName().toLowerCase()+"_attaque.png");
                } catch (Exception exception) {
                }
                ArrayList<JLabel> attaqueLabels = new ArrayList<>();
                JLabel attaqueLabel1 = new JLabel(attaque1);
                JLabel attaqueLabel2 = new JLabel(attaque2);
                JLabel attaqueLabel3 = new JLabel(attaque3);
                JLabel attaqueLabel4 = new JLabel(attaque4);
                attaqueLabels.add(attaqueLabel1);
                attaqueLabels.add(attaqueLabel2);
                attaqueLabels.add(attaqueLabel3);
                attaqueLabels.add(attaqueLabel4);

                for(int i = 0; i<4; i++){
                    String PP = playerTeam.getActivePokemon().getAttaques().get(i).getName() + " "+Integer.toString(playerTeam.getActivePokemon().getAttaques().get(i).getPp())+ "/"+ Integer.toString(playerTeam.getActivePokemon().getAttaques().get(i).getPpMax());
                    attaqueLabels.get(i).setText(PP);
                    attaqueLabels.get(i).setHorizontalTextPosition(JLabel.CENTER);
                    attaqueLabels.get(i).setVerticalTextPosition(JLabel.CENTER);
                    attaqueLabels.get(i).setForeground(Color.white);
                    attaqueLabels.get(i).setFont(UIManager.getFont("Label.font").deriveFont(26f));
                }

                buttonGbc.gridx = 0;
                buttonGbc.gridy = 0;
                buttonPanel.add(attaqueLabel1, buttonGbc);

                buttonGbc.gridx = 1;
                buttonGbc.gridy = 1;
                buttonPanel.add(attaqueLabel2, buttonGbc);

                buttonGbc.gridx = 1;
                buttonGbc.gridy = 0;
                buttonPanel.add(attaqueLabel3, buttonGbc);

                buttonGbc.gridx = 0;
                buttonGbc.gridy = 1;
                buttonPanel.add(attaqueLabel4, buttonGbc);
            }
        });
        return buttonPanel;
    }
}