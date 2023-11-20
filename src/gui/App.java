package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Pokemon.*;

public class App extends JFrame {
    private StringBuilder typedText = new StringBuilder();
    private boolean isKirby = false;

    public App() {
        setTitle("Street Pokemon Fighter Phantom 2 Turbo Championship Edition EX + Alpha X");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 950);
        setLocationRelativeTo(null);
        setResizable(false);

        Action keyAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("k")) {
                    typedText = new StringBuilder();
                    typedText.append("k");
                } else {
                    typedText.append(e.getActionCommand());
                }

                if (typedText.toString().equals("kirby") && !isKirby) {
                    isKirby = true;
                    System.out.println("CHEATCODE ACTIVATED: Kirby added to the game !");
                }
            }
        };

        ImagePanel imagePanel = new ImagePanel("../Assets/Background/maxresdefault.jpg", 700, 400);
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
        boolean containsKirby = false;
        for (Pokemon pokemon : PokemonList.getPokemons()) {
            if (pokemon.getName().equals("Kirby")) {
                containsKirby = true;
                break;
            }
        }
        return isKirby && !containsKirby ? PokemonList.getPokemonsWithKirby() : PokemonList.getPokemons();
    }
}