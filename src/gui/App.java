package gui;

import java.awt.*;
import javax.swing.*;


public class App extends JFrame {


    public App() {
        setTitle("Street Pokemon Fighter Phantom 2 Turbo Championship Edition EX + Alpha X");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 800);
        setLocationRelativeTo(null);

        ImagePanel imagePanel = new ImagePanel("../Assets/maxresdefault.jpg", 700, 400);
        ButtonPanel buttonPanel = new ButtonPanel(this);
        buttonPanel.setPreferredSize(new Dimension(buttonPanel.getPreferredSize().width, 100));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(imagePanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }
}