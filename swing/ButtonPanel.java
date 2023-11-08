// package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel {
    private JFrame frame;

    public ButtonPanel(JFrame frame) {
        this.frame = frame;
        setLayout(new GridLayout(1, 4));
        JButton button1 = new JButton("PLAY ! ");
        JButton button2 = new JButton("EXIT");
        ChooseTeamUI chooseTeamUI = new ChooseTeamUI();

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(chooseTeamUI, BorderLayout.CENTER);
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
