package gui;

import Team.*;
import javax.swing.*;
import java.awt.*;

public class TeamGrid extends JPanel {
    public TeamGrid(Team team, Color borderColor) {
        super(new GridLayout(1, 6));
        for (int i = 0; i < 6; i++) {
            JLabel label = new JLabel("");
            ImageIcon icon = new ImageIcon("../Assets/" + team.getTeam().get(i).getSpritePng());
            label.setIcon(icon);
            label.setBorder(BorderFactory.createLineBorder(borderColor));
            add(label);
        }
    }
}