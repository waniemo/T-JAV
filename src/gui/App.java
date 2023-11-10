package gui;

import java.awt.*;
import java.util.Arrays;
import java.awt.event.*;
import javax.swing.*;

import Pokemon.*;


public class App extends JFrame {
    private StringBuilder typedText = new StringBuilder();
    private Pokemon[] pokemons;
    private boolean isKirby = false;

    public App() {
        setTitle("Street Pokemon Fighter Phantom 2 Turbo Championship Edition EX + Alpha X");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 800);
        setLocationRelativeTo(null);

        Action keyAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typedText.append(e.getActionCommand());
                if (typedText.toString().equals("kirby")) {
                    isKirby = true;
                    System.out.println("CHEATCODDE ACTIVATED: Kirby added to the game !");
                }
            }
        };

        ImagePanel imagePanel = new ImagePanel("../Assets/maxresdefault.jpg", 700, 400);
        for (char c = 'a'; c <= 'z'; c++) {
            imagePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(c), c);
            imagePanel.getActionMap().put(c, keyAction);
        }
        ButtonPanel buttonPanel = new ButtonPanel(this);
        buttonPanel.setPreferredSize(new Dimension(buttonPanel.getPreferredSize().width, 100));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(imagePanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    public Pokemon[] getPokemons() {
        return isKirby ? PokemonList.getPokemonsWithKirby() : PokemonList.getPokemons();
    }
}