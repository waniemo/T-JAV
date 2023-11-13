package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel {

    public ButtonPanel(App frame) {
        setLayout(new GridLayout(1, 4));
        JButton button1 = new JButton("JOUER ! ");
        JButton button2 = new JButton("QUITTER");

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new ChooseTeamUI(frame), BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(button1);
        add(button2);
    }
}
