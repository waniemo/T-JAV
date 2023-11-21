package gui;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import Team.Team;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class SelectXpUI extends JPanel {
    private Image backgroundImage;
    private static PlaySound sound = new PlaySound();

    public SelectXpUI(App frame, Team playerTeam, Team enemyTeam) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/Background/menu1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel selector = new JPanel(new GridLayout(2, 1));
        selector.setOpaque(false);
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
                sound.playSound("button", frame.hasSound());

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
            sound.playSound("button", frame.hasSound());

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}
