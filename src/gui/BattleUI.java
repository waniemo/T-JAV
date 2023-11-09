package gui;

import java.awt.*;

import javax.swing.*;

import Team.*;

public class BattleUI extends JPanel {
    public BattleUI(JFrame frame, Team playerTeam, Team enemyTeam) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        TeamGrid playerTeamGrid = new TeamGrid(playerTeam, Color.BLUE);
        TeamGrid enemyTeamGrid = new TeamGrid(enemyTeam, Color.RED);
        JButton backButton = new JButton("RETOUR");
        JButton playButton = new JButton("C'EST PARTI!");

        JLabel playerTitle = new JLabel("Ton équipe! ( lvl" + playerTeam.getLevel() + ")");
        JLabel enemyTitle = new JLabel("Equipe ennemie! ( lvl" + enemyTeam.getLevel() + ")");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(playerTitle, gbc);
        gbc.gridy = 1;
        add(playerTeamGrid, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(enemyTeamGrid, gbc);
        gbc.gridy = 3;
        add(enemyTitle, gbc);

        backButton.addActionListener(e -> {
            SelectXpUI selectXpUI = new SelectXpUI(frame, playerTeam, enemyTeam);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(selectXpUI, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
        });
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(playButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(backButton, gbc);

    }
}
