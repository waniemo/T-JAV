package gui;

import Team.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TeamGrid extends JPanel {
    public TeamGrid(App frame, Team team, Color borderColor) {
        super(new GridLayout(1, 6));
        buildTeamGrid(frame, team, borderColor);
    }

    private void buildTeamGrid(App frame, Team team, Color borderColor) {
        for (int i = 0; i < 6; i++) {
            JPanel pokemonPanel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("");
            ImageIcon icon = null;
            PvBar pvBar = new PvBar(team.getTeam().get(i));
            int index = i;
            if (team.getDeadPokemons().contains(team.getTeam().get(i))) {
                icon = new ImageIcon("../Assets/" + team.getTeam().get(i).getKoPng());
            } else {
                icon = new ImageIcon("../Assets/" + team.getTeam().get(i).getSpritePng());
            }
            label.setIcon(icon);
            if (team.getTeam().get(i) == team.getActivePokemon()) {
                label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            } else {
                label.setBorder(BorderFactory.createLineBorder(borderColor));
            }

            pokemonPanel.add(label, BorderLayout.CENTER);
            pokemonPanel.add(pvBar, BorderLayout.SOUTH);

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(team.setActivePokemon(team.getTeam().get(index)));
                    removeAll(); // Remove all components from the panel
                    buildTeamGrid(frame, team, borderColor); // Rebuild the panel's components
                    revalidate(); // Inform the system that the panel's layout has changed
                    repaint(); // Redraw the panel
                }
            });
            add(pokemonPanel);
        }
    }
}