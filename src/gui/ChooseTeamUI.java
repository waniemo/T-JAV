
package gui;

import Pokemon.*;
import Team.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class ChooseTeamUI extends JPanel {
    private final List<JLabel> teamLabels = new ArrayList<>();
    Pokemon[] pokemons = {
            new Blizzaroi(), new Bulbizarre(), new Dialga(),
            new Doudouvet(), new Gardevoir(), new Hericendre(),
            new Lugulabre(), new Magicarpe(), new Noadkoko(),
            new Ponyta(), new Psykokwak(), new Raichu(),
            new Reshiram(), new Rondoudou(), new Tiplouf(),
            new Viridium(), new Voltali(), new Voltorbe(),
            new Zekrom(), new Kirby()
    };
    private List<Pokemon> team = new ArrayList<>();

    public ChooseTeamUI(JFrame frame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel teamGrid = new JPanel(new GridLayout(1, 6));
        Dimension teamGridSize = new Dimension(600, 100);
        teamGrid.setPreferredSize(teamGridSize);
        JPanel selectGrid = new JPanel(new GridLayout(5, 4));
        JPanel buttonPanel = new JPanel();
        ImageIcon greyBall = new ImageIcon("../Assets/grey_flat_pokeball.png");

        for (int i = 0; i < 6; i++) {
            JLabel label = new JLabel("");
            label.setIcon(greyBall);
            teamLabels.add(label);
            teamGrid.add(label);
        }

        for (int i = 0; i < 20; i++) {
            ImageIcon icon = new ImageIcon("../Assets/" + pokemons[i].getSpritePng());
            JLabel label = new JLabel(icon);
            int index = i;
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JLabel teamLabel : teamLabels) {
                        if (teamLabel.getIcon() == greyBall) {
                            teamLabel.setIcon(label.getIcon());
                            team.add(pokemons[index]);
                            System.out.println(team);
                            break;
                        }
                    }
                }
            });
            selectGrid.add(label);
        }

        Team enemyTeam = new Team(new ArrayList<Pokemon>());
        List<Integer> enemyTeamIndexes = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * 20);
            while (enemyTeamIndexes.contains(index)) {
                index = (int) (Math.random() * 20);
            }
            enemyTeamIndexes.add(index);
            enemyTeam.addPokemon(pokemons[index]);
        }

        JButton button1 = new JButton("Continuer");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Team playerTeam = new Team(team);
                SelectXpUI selectXpUI = new SelectXpUI(frame, playerTeam, enemyTeam);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(selectXpUI, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            }
        });
        JButton button2 = new JButton("Quitter");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        add(teamGrid, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.3;
        add(selectGrid, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.2;
        add(buttonPanel, gbc);
    }
}