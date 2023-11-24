package gui;

import Team.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class SummaryPanel extends JPanel {
    private GridBagConstraints gbc = new GridBagConstraints();
    private Image backgroundImage;
    private static PlaySound sound = new PlaySound();

    public SummaryPanel(App frame, Team playerTeam, Team enemyTeam) {
        try {
            InputStream imageStream = ArenaPanel.class.getClassLoader().getResourceAsStream("Assets/Background/menu4.png");
            backgroundImage = ImageIO.read(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());

        TeamGrid playerTeamGrid = new TeamGrid(frame, playerTeam, Color.BLUE);
        TeamGrid enemyTeamGrid = new TeamGrid(frame, enemyTeam, Color.RED);
        JButton backButton = new JButton("RETOUR");
        JLabel playerTitle = new JLabel("Ton équipe! ( lvl" + playerTeam.getLevel() + ")");
        JLabel enemyTitle = new JLabel("Equipe ennemie! ( lvl" + enemyTeam.getLevel() + ")");

        backButton.addActionListener(e -> {
            sound.playSound("button", frame.hasSound());

            SelectXpUI selectXpUI = new SelectXpUI(frame, playerTeam, enemyTeam);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(selectXpUI, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
        });
        gbc.insets = new Insets(120, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(playerTitle, gbc);
        gbc.gridy = 1;
        add(playerTeamGrid, gbc);

        gbc.insets = new Insets(230, 0, 0, 0);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}