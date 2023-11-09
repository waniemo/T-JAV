package gui;

import java.awt.*;

import javax.swing.*;

import Team.Team;

public class BattleUI extends JPanel {
    public BattleUI(JFrame frame, Team playerTeam, Team enemyTeam) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel playerTeamGrid = new JPanel(new GridLayout(1, 6));
        JPanel enemyTeamGrid = new JPanel(new GridLayout(1, 6));

        if (playerTeam.getTeam().size() < 6 || enemyTeam.getTeam().size() < 6) {
            // Handle the error, e.g., show an error message and return
            System.err.println("Not enough Pokemons in the teams");
            return;
        }
        for (int i = 0; i < 6; i++) {
            JLabel label = new JLabel("");
            ImageIcon icon = new ImageIcon("../Assets/" + playerTeam.getTeam().get(i).getSpritePng());
            label.setIcon(icon);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            playerTeamGrid.add(label);
        }

        for (int i = 0; i < 6; i++) {
            JLabel label = new JLabel("");
            ImageIcon icon = new ImageIcon("../Assets/" + enemyTeam.getTeam().get(i).getSpritePng());
            label.setIcon(icon);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            enemyTeamGrid.add(label);
        }

        JLabel playerTitle = new JLabel("Ton équipe!");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(playerTitle, gbc);
        gbc.gridy = 1;
        add(playerTeamGrid, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(enemyTeamGrid, gbc);
        JLabel enemyTitle = new JLabel("Equipe ennemie!");
        gbc.gridy = 3;
        add(enemyTitle, gbc);

        JButton backButton = new JButton("RETOUR");
        backButton.addActionListener(e -> {
            SelectXpUI selectXpUI = new SelectXpUI(frame, playerTeam, enemyTeam);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(selectXpUI, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(backButton, gbc);

    }
}
