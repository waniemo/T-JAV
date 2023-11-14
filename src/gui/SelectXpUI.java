package gui;

import java.awt.*;
import javax.swing.*;

import Team.Team;

import java.awt.event.*;

public class SelectXpUI extends JPanel {
    public SelectXpUI(App frame, Team playerTeam, Team enemyTeam) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel selector = new JPanel(new GridLayout(2, 1));
        Dimension selectorSize = new Dimension(1000, 150);
        selector.setPreferredSize(selectorSize);
        selector.setMaximumSize(selectorSize);

        CustomSpinner spinner1 = new CustomSpinner(1, 100, 1);
        CustomSpinner spinner2 = new CustomSpinner(1, 100, 1);
        JButton playButton = new JButton("JOUER!");
        JButton backButton = new JButton("RETOUR");

        JLabel labelPlayer = new JLabel("Niveau de votre équipe:");
        labelPlayer.setFont(getFont().deriveFont(40f));
        selector.add(labelPlayer);
        selector.add(spinner1);
        selector.add(Box.createHorizontalGlue());
        JLabel labelEnemy = new JLabel("Niveau de l'ennemi:");
        labelEnemy.setFont(getFont().deriveFont(40f));
        selector.add(labelEnemy);
        selector.add(spinner2);

        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerTeam.setTeamLevel((int) spinner1.getValue());
                enemyTeam.setTeamLevel((int) spinner2.getValue());
                BattleUI battleUI = new BattleUI(frame, playerTeam, enemyTeam);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(battleUI, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            }
        });

        backButton.addActionListener(e -> {
            ChooseTeamUI chooseTeamUI = new ChooseTeamUI(frame);
            playerTeam.getTeam().clear();
            frame.getContentPane().removeAll();
            frame.getContentPane().add(chooseTeamUI, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
        });

        add(Box.createVerticalGlue());
        add(selector);
        add(Box.createVerticalGlue());
        add(playButton);
        add(backButton);
    }
}
