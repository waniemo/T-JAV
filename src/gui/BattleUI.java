package gui;

import javax.swing.*;

import Team.Team;

public class BattleUI extends JPanel {
    public BattleUI(JFrame frame, Team playerTeam, Team enemyTeam) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new ImagePanel("../Assets/maxresdefault.jpg", 700, 400));
        add(new ButtonPanel(frame));
    }
}
