package gui;

import Team.*;

import javax.swing.*;
import java.awt.*;

public class PanelHelper {
    public static JPanel createTeamPanel(Team team) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel(team.getActivePokemon().getName());
        JLabel levelLabel = new JLabel("Niveau " + team.getActivePokemon().getLevel());
        JLabel typeLabel = new JLabel(team.getActivePokemon().getType().toString());
        panel.setBackground(Color.LIGHT_GRAY);

        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        levelLabel.setFont(new Font("Arial", Font.BOLD, 20));
        typeLabel.setIcon(new ImageIcon("../Assets/feu.png"));

        PvBar pvBar = new PvBar(team.getActivePokemon());
        pvBar.updateBar();
        panel.add(nameLabel, BorderLayout.WEST);
        panel.add(levelLabel, BorderLayout.EAST);
        panel.add(pvBar, BorderLayout.SOUTH);

        return panel;
    }


    public static JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints buttonGbc = new GridBagConstraints();
        for (int i = 0; i < 3; i++) {
            buttonGbc.gridx = i;
            if (i == 2) {
                buttonGbc.gridy = 1;
                buttonGbc.gridwidth = 2;
                buttonGbc.gridx = 0;
            } else {
                buttonGbc.gridy = 0;
                buttonGbc.gridwidth = 1;
            }
            buttonPanel.add(new JButton("Button " + (i + 1)), buttonGbc);
        }
        return buttonPanel;
    }
}