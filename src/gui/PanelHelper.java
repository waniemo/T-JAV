package gui;

import Team.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        return buttonPanel;
    }
}