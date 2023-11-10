package gui;

import java.awt.*;
import javax.swing.*;
import Team.*;

public class BattleUI extends JPanel {
    private SummaryPanel summaryPanel;
    private ArenaPanel arenaPanel;

    public BattleUI(App frame, Team playerTeam, Team enemyTeam) {
        setLayout(new BorderLayout());

        arenaPanel = new ArenaPanel(frame, playerTeam, enemyTeam);
        summaryPanel = new SummaryPanel(frame, playerTeam, enemyTeam);
        add(summaryPanel, BorderLayout.CENTER);

        JButton playButton = new JButton("C'EST PARTI!");
        playButton.addActionListener(e -> {
            remove(summaryPanel);

            add(arenaPanel, BorderLayout.CENTER);

            revalidate();
            repaint();
        });

        summaryPanel.add(playButton, summaryPanel.getGbc());
    }
}