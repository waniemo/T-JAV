
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

        Dimension teamGridSize = new Dimension(600, 100);
        JPanel selectGrid = new JPanel(new GridLayout(5, 4));
        JPanel teamGrid = new JPanel(new GridLayout(1, 6));
        teamGrid.setPreferredSize(teamGridSize);

        ImageIcon greyBall = new ImageIcon("../Assets/grey_flat_pokeball.png");
        Team enemyTeam = TeamBuilder.buildEnemyTeam(pokemons);

        for (int i = 0; i < 6; i++) {
            JLabel label = new JLabel("");
            label.setIcon(greyBall);
            teamLabels.add(label);
            teamGrid.add(label);
        }

        TeamBuilder.addPokemonToGrid(selectGrid, pokemons, team, teamLabels, greyBall);

        ButtonPanel2 buttonPanel = new ButtonPanel2(frame, team, enemyTeam);

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