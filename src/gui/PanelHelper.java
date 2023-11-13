package gui;

import Team.*;

import javax.swing.*;
import java.awt.*;

public class PanelHelper {
    public static JPanel createTeamPanel(App frame, Team team) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel(team.getActivePokemon().getName());
        JLabel levelLabel = new JLabel("Niveau " + team.getActivePokemon().getLevel());
        JLabel typeLabel = new JLabel(team.getActivePokemon().getType().toString());
        panel.setBackground(Color.LIGHT_GRAY);

        nameLabel.setFont(frame.getFont().deriveFont(40f));
        levelLabel.setFont(frame.getFont().deriveFont(40f));
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
        GridBagConstraints buttonGbc = new GridBagConstraints();
        String[] buttonNames = { "attack", "bag", "change" };

        for (int i = 0; i < buttonNames.length; i++) {
            buttonGbc.gridx = i;
            if (i == 0) {
                buttonGbc.gridy = 0;
                buttonGbc.gridwidth = 2;
                buttonGbc.gridx = 1;
            } else {
                buttonGbc.gridy = 1;
                buttonGbc.gridwidth = 1;
            }
            JButton button = new JButton(buttonNames[i]);
            switch (i) {
                case 0:
                    button.addActionListener(e -> {
                        // action for "attack" button
                    });
                    break;
                case 1:
                    button.addActionListener(e -> {
                        // action for "bag" button
                        frame.setContentPane(new Bag(frame, arena, playerTeam, enemyTeam));
                        frame.revalidate();

                    });
                    break;
                case 2:
                    button.addActionListener(e -> {
                        // action for "change" button
                    });
                    break;
            }
            buttonPanel.add(button, buttonGbc);
        }
        return buttonPanel;
    }
}