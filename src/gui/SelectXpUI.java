package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class SelectXpUI extends JPanel {
    public SelectXpUI(JFrame frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel selector = new JPanel(new GridLayout(1, 2));
        Dimension selectorSize = new Dimension(1000, 50);
        selector.setPreferredSize(selectorSize);
        selector.setMaximumSize(selectorSize);

        CustomSpinner spinner1 = new CustomSpinner(1, 100, 1);
        CustomSpinner spinner2 = new CustomSpinner(1, 100, 1);

        selector.add(new JLabel("Niveau de votre équipe:"));
        selector.add(spinner1);
        selector.add(Box.createHorizontalGlue());
        selector.add(new JLabel("Niveau de l'ennemi:"));
        selector.add(spinner2);

        JButton playButton = new JButton("PLAY!");
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BattleUI battleUI = new BattleUI();
                frame.getContentPane().removeAll();
                frame.getContentPane().add(battleUI, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
            }
        });

        add(Box.createVerticalGlue());
        add(selector);
        add(Box.createVerticalGlue());
        add(playButton);
    }
}
