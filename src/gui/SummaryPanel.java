package gui;

import Team.*;
import javax.swing.*;
import java.awt.*;

public class SummaryPanel extends JPanel {
    GridBagConstraints gbc = new GridBagConstraints();
    public SummaryPanel(App frame, Team playerTeam, Team enemyTeam) {
        setLayout(new GridBagLayout());

        TeamGrid playerTeamGrid = new TeamGrid(frame, playerTeam, Color.BLUE);
        TeamGrid enemyTeamGrid = new TeamGrid(frame, enemyTeam, Color.RED);
        JButton backButton = new JButton("RETOUR");
        JLabel playerTitle = new JLabel("Ton équipe! ( lvl" + playerTeam.getLevel() + ")");
        JLabel enemyTitle = new JLabel("Equipe ennemie! ( lvl" + enemyTeam.getLevel() + ")");

        backButton.addActionListener(e -> {
                SelectXpUI selectXpUI = new SelectXpUI(frame, playerTeam, enemyTeam);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(selectXpUI, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            });
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

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(backButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}