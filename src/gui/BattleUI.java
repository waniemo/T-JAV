package gui;

import java.awt.*;
import javax.swing.*;
import Team.*;

public class BattleUI extends JPanel {
    private SummaryPanel summaryPanel;
    private ArenaPanel arenaPanel;
    private static PlaySound sound = new PlaySound();

    public BattleUI(App frame, Team playerTeam, Team enemyTeam) {
        setLayout(new BorderLayout());

        arenaPanel = new ArenaPanel(frame, playerTeam, enemyTeam, sound);
        summaryPanel = new SummaryPanel(frame, playerTeam, enemyTeam);
        add(summaryPanel, BorderLayout.CENTER);

        JButton playButton = new JButton("C'EST PARTI!");
        playButton.addActionListener(e -> {
            sound.playSound("button", frame.hasSound());
            sound.playSound("start_battle", frame.hasSound());
            sound.loopSound("battle", frame.hasSound());

            remove(summaryPanel);

            add(arenaPanel, BorderLayout.CENTER);

            revalidate();
            repaint();
        });

        summaryPanel.add(playButton, summaryPanel.getGbc());
    }
}