package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Team.Team;

public class ChangePokemon extends JPanel {
    private Image backgroundImage;
    public ChangePokemon(App frame, ArenaPanel arena, Team playerTeam, Team enemyTeam) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/change_pokemon_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        TeamGrid playerTeamGrid = new TeamGrid(frame, playerTeam, Color.BLUE);

        JLabel playerTitle = new JLabel("CHOISIS UN POKEMON A ENVOYER AU COMBAT");
        playerTitle.setFont(getFont().deriveFont(35f));

        JButton backButton = new JButton("RETOUR");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arena.getPlayerPvBar().updateBar();
                frame.setLayout(new BorderLayout());
                frame.getContentPane().removeAll();
                frame.getContentPane().add(arena, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(180, 20, 20, 20);
        add(playerTeamGrid, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(120, 20, 20, 20);
        add(backButton, gbc);
        gbc.gridy = 3;
        gbc.insets = new Insets(60, 100, 100, 100);
        add(playerTitle, gbc);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}
