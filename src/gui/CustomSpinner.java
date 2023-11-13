package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSpinnerUI;

public class CustomSpinner extends JSpinner {
    public CustomSpinner(int min, int max, int step) {
        super(new SpinnerNumberModel(min, min, max, step));

        setUI(new BasicSpinnerUI() {
            protected Component createNextButton() {
                Component c = createArrowButton(SwingConstants.NORTH);
                installNextButtonListeners(c);
                return c;
            }
            protected Component createPreviousButton() {
                Component c = createArrowButton(SwingConstants.SOUTH);
                installPreviousButtonListeners(c);
                return c;
            }
            private Component createArrowButton(int direction) {
                BasicArrowButton bab = new BasicArrowButton(direction);
                bab.setBackground(Color.RED);
                bab.setForeground(Color.WHITE);
                return bab;
            }
        });

        setFont(getFont().deriveFont(40f));
        setBorder(new EmptyBorder(5, 5, 5, 5));
    }
}
