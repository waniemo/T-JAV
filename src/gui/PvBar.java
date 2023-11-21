package gui;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import java.awt.Color;

import Pokemon.Pokemon;

public class PvBar extends JProgressBar {
    private Pokemon pokemon;

    public PvBar(Pokemon pokemon) {
        super(0, pokemon.getPvMax());
        this.pokemon = pokemon;
        setValue(pokemon.getPv());
        updateBar(false);
        setStringPainted(true);
    }

    private class UpdatePvTask extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            if (getValue() > pokemon.getPv()) {
                for (int i = getValue(); i >= pokemon.getPv(); i--) {
                    setValue(i);
                    Thread.sleep(50);
                }
            } else if (getValue() < pokemon.getPv()) {
                for (int i = getValue(); i <= pokemon.getPv(); i++) {
                    setValue(i);
                    Thread.sleep(50);
                }
            }
            return null;
        }

        @Override
        protected void done() {
            super.done();
        }
    }

    public void updateBar(boolean animation) {
        if (animation) {
            new UpdatePvTask().execute();
        } else {
            setValue(pokemon.getPv());
        }

        double percentage = (double) getValue() / getMaximum();
        if (percentage < 0.15) {
            setForeground(Color.RED);
        } else if (percentage < 0.3) {
            setForeground(Color.ORANGE);
        } else {
            setForeground(Color.GREEN);
        }
    }
}