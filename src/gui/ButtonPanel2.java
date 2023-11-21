package gui;

import Team.*;
import javax.swing.*;

import Pokemon.Pokemon;

import java.awt.event.*;
import java.awt.*;
import java.util.List;

public class ButtonPanel2 extends JPanel {
    private static JButton button1 = new JButton("CONTINUER");
    private static PlaySound sound = new PlaySound();

    public ButtonPanel2(App frame, List<Pokemon> team, Team enemyTeam) {
        button1.setEnabled(false);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Team playerTeam = new Team(team);
                sound.playSound("button", frame.hasSound());
                if (playerTeam.getTeam() != null) {
                    if (playerTeam.getTeam().size() < 6 || enemyTeam.getTeam().size() < 6) {
                        System.err.println("Not enough Pokemons in the teams");
                        return;
                    }
                    System.out.println(playerTeam.getTeam());
                    SelectXpUI selectXpUI = new SelectXpUI(frame, playerTeam, enemyTeam);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(selectXpUI, BorderLayout.CENTER);
                    frame.revalidate();
                    frame.repaint();
                }
            }
        });
        JButton button2 = new JButton("QUITTER");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sound.playSound("button", frame.hasSound());
                Thread thread = new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.exit(0);
                    }
                };
                thread.run();
            }
        });

        JButton button3 = new JButton("VIDER");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChooseTeamUI chooseTeamUI = new ChooseTeamUI(frame);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(chooseTeamUI, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            }
        });
        add(button1);
        add(button2);
        add(button3);
    }

    public static void activateButton() {
        button1.setEnabled(true);
    }
}