package gui;

import javax.swing.*;
import java.awt.*;

public class TextBox extends JLabel {
    private String text;
    public TextBox(String text) {
        ImageIcon icon = new ImageIcon("../Assets/text_box.png");
        setOpaque(false);
        Image textBoxImage = icon.getImage();
        Image image = textBoxImage.getScaledInstance(610, 96, Image.SCALE_SMOOTH);
        this.setFont(UIManager.getFont("Label.font").deriveFont(30f));
        icon.setImage(image);
        this.setIcon(icon);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setText(text);
    }

    public void updateText(String text) {
        this.text = text;
        super.setText(text);

        new TypeTextTask().execute();
    }

    private class TypeTextTask extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i <= text.length(); i++) {
                final String partialText = text.substring(0, i);
                setText(partialText);
                Thread.sleep(35);
            }
            return null;
        }

        @Override
        protected void done() {
            super.done();
        }
    }
}
