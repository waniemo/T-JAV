
package gui;

import Pokemon.*;
import Team.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.*;

public class ChooseTeamUI extends JPanel {
    private final List<JLabel> teamLabels = new ArrayList<>();
    private Pokemon[] pokemons = null;
    private List<Pokemon> team = new ArrayList<>();
    App app;

    public ChooseTeamUI(App frame) {
        app = frame;
        pokemons = frame.getPokemons();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Dimension teamGridSize = new Dimension(600, 100);
        JPanel selectGrid = new JPanel(new GridLayout(5, 6));
        JPanel teamGrid = new JPanel(new GridLayout(1, 6));
        JPanel typeGrid = new JPanel(new GridLayout(5, 1));
        teamGrid.setPreferredSize(teamGridSize);

        ImageIcon greyBall = new ImageIcon("../Assets/grey_flat_pokeball.png");
        String[] types = { "../Assets/feu.png", "../Assets/electrik.png", "../Assets/plante.png", "../Assets/eau.png",
                "../Assets/fee.png" };
        Team enemyTeam = TeamBuilder.buildEnemyTeam(pokemons);

        for (int i = 0; i < 5; i++) {
            ImageIcon icon = new ImageIcon(types[i]);
            JLabel label = new JLabel(icon);
            label.setPreferredSize(new Dimension(100, 100));
            typeGrid.add(label);
        }

        for (int i = 0; i < 6; i++) {
            JLabel label = new JLabel("");
            label.setIcon(greyBall);
            teamLabels.add(label);
            teamGrid.add(label);
        }

        TeamBuilder.addPokemonToGrid(selectGrid, pokemons, team, teamLabels, greyBall);

        ButtonPanel2 buttonPanel = new ButtonPanel2(frame, team, enemyTeam);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        add(teamGrid, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.weighty = 0.3;
        add(selectGrid, gbc);

        gbc.gridy = 1;
        gbc.gridx = 2;
        add(typeGrid, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.weighty = 0.2;
        add(buttonPanel, gbc);
    }
}