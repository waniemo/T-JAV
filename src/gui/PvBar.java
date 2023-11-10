package gui;

import javax.swing.JProgressBar;
import java.awt.Color;

import Pokemon.Pokemon;

public class PvBar extends JProgressBar {
    private Pokemon pokemon;

    public PvBar(Pokemon pokemon) {
        super(0, pokemon.getPvMax());
        this.pokemon = pokemon;
        updateBar();
        setStringPainted(true);
    }

    public void updateBar() {
        setValue(pokemon.getPv());

        double percentage = (double) getValue() / getMaximum();
        if (percentage < 0.15) {
            setForeground(Color.RED);
        }
        else if (percentage < 0.3) {
            setForeground(Color.ORANGE);
        }
        else {
            setForeground(Color.GREEN);
        }
    }
}