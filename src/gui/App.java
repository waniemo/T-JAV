package gui;

import java.awt.*;
import javax.swing.*;

// import swing.ButtonPanel;
// import swing.ImagePanel;

public class App extends JFrame {


    public App() {
        setTitle("Street Pokemon Fighter 2 Turbo Championship Edition EX + Alpha X");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 800);
        setLocationRelativeTo(null);

        ImagePanel imagePanel = new ImagePanel("../Assets/maxresdefault.jpg", 700, 400);
        ButtonPanel buttonPanel = new ButtonPanel(this);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(imagePanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }
}