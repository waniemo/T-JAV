package gui;

import Team.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TeamGrid extends JPanel {
    private String text;
    private static ImageIcon icon = null;

    public TeamGrid(App frame, Team team, Color borderColor) {
        super(new GridLayout(1, 6));
        buildTeamGrid(frame, team, borderColor);
    }

    private void buildTeamGrid(App frame, Team team, Color borderColor) {
        for (int i = 0; i < 6; i++) {
            JPanel pokemonPanel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("");
            PvBar pvBar = new PvBar(team.getTeam().get(i));
            int index = i;
            if (team.getDeadPokemons().contains(team.getTeam().get(i))) {

                java.net.URL imageURL = ChooseTeamUI.class.getClassLoader()
                        .getResource("Assets/" + team.getTeam().get(i).getKoPng());

                if (imageURL != null) {
                    // Create ImageIcon from InputStream
                    try (java.io.InputStream stream = imageURL.openStream()) {
                        icon = new ImageIcon(javax.imageio.ImageIO.read(stream));
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Image not found: text_box.png");
                }
            } else {
                java.net.URL imageURL = ChooseTeamUI.class.getClassLoader()
                        .getResource("Assets/" + team.getTeam().get(i).getSpritePng());

                if (imageURL != null) {
                    // Create ImageIcon from InputStream
                    try (java.io.InputStream stream = imageURL.openStream()) {
                        icon = new ImageIcon(javax.imageio.ImageIO.read(stream));
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Image not found: text_box.png");
                }
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
                    text = team.setActivePokemon(team.getTeam().get(index));
                    removeAll(); // Remove all components from the panel
                    buildTeamGrid(frame, team, borderColor); // Rebuild the panel's components
                    revalidate(); // Inform the system that the panel's layout has changed
                    repaint(); // Redraw the panel
                }
            });
            add(pokemonPanel);
        }
    }

    public String getText() {
        return text;
    }
}