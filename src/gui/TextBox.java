package gui;

import javax.swing.*;
import java.awt.*;

public class TextBox extends JLabel {
    private String text;
    private Object lock = new Object();
    private TypeTextTask currentTask = null;

    public TextBox(String text) {
        ImageIcon icon = new ImageIcon("../Assets/Background/text_box.png");
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

    public void updateText(String text, boolean animation) {

        synchronized (lock) {
            this.text = text;
            if (!animation) {
                super.setText(text);
            } else {
                if (currentTask != null) {
                    currentTask.cancel(true);
                }
                currentTask = new TypeTextTask();
                currentTask.execute();
            }
            System.out.println(text);
        }
    }

    private class TypeTextTask extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i <= text.length(); i++) {
                final String partialText = text.substring(0, i);
                setText(partialText);
                Thread.sleep(35);
                System.out.println(partialText);
            }
            return null;
        }

        @Override
        protected void done() {
            super.done();
        }
    }
}
