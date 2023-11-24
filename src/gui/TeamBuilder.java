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
            int index = (int) (Math.random() * 28);
            while (enemyTeamIndexes.contains(index)) {
                index = (int) (Math.random() * 28);
            }
            enemyTeamIndexes.add(index);
            try {
                enemyList.add(pokemons[index].getClass().getDeclaredConstructor().newInstance());
            } catch (Exception noPokemon) {
            }
        }
        return new Team(enemyList);
    }

    public static void addPokemonToGrid(JPanel selectGrid, Pokemon[] pokemons, List<Pokemon> team,
            List<JLabel> teamLabels, ImageIcon greyBall) {
        for (int i = 0; i < pokemons.length; i++) {
            java.net.URL imageURL = ChooseTeamUI.class.getClassLoader().getResource("Assets/" + pokemons[i].getSpritePng());
            if (imageURL != null) {
                // Create ImageIcon from InputStream
                try (java.io.InputStream stream = imageURL.openStream()) {
                    ImageIcon icon = new ImageIcon(javax.imageio.ImageIO.read(stream));
                    JLabel label = new JLabel("");
                    label.setIcon(icon);
                    int index = i;
                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            for (JLabel teamLabel : teamLabels) {
                                if (teamLabel.getIcon() == greyBall) {
                                    teamLabel.setIcon(label.getIcon());
                                    try {
                                        team.add(pokemons[index].getClass().getDeclaredConstructor().newInstance());
                                    } catch (Exception noPokemon) {}
                                    break;
                                }
                            }
                            if (team.size() == 6) {
                                ButtonPanel2.activateButton();
                            }
                        }
                    });
                    selectGrid.add(label);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Image not found: grey_flat_pokeball");
            }
        }
    }
}
