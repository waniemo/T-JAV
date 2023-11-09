package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.*;

import Team.*;
import Pokemon.*;


public class TeamBuilder {
    public static Team buildEnemyTeam(Pokemon[] pokemons) {
        List<Integer> enemyTeamIndexes = new ArrayList<>();
        List<Pokemon> enemyList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * 18);
            while (enemyTeamIndexes.contains(index)) {
                index = (int) (Math.random() * 18);
            }
            enemyTeamIndexes.add(index);
            enemyList.add(pokemons[index]);
        }
        return new Team(enemyList);
    }

    public static void addPokemonToGrid(JPanel selectGrid, Pokemon[] pokemons, List<Pokemon> team, List<JLabel> teamLabels, ImageIcon greyBall) {
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
                            break;
                        }
                    }
                }
            });
            selectGrid.add(label);
        }
    }
}
