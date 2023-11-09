package gui;

import Team.*;
import javax.swing.*;

import Pokemon.Pokemon;

import java.awt.event.*;
import java.awt.*;
import java.util.List;


public class ButtonPanel2 extends JPanel {
    public ButtonPanel2(JFrame frame, List<Pokemon> team, Team enemyTeam) {
        JButton button1 = new JButton("Continuer");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Team playerTeam = new Team(team);
                SelectXpUI selectXpUI = new SelectXpUI(frame, playerTeam, enemyTeam);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(selectXpUI, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            }
        });
        JButton button2 = new JButton("Quitter");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(button1);
        add(button2);
    }
}