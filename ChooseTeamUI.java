import javax.swing.*;
import java.awt.*;

public class ChooseTeamUI extends JPanel {
    public ChooseTeamUI() {
        setLayout(new GridLayout(5, 4)); // Set layout to 5x4 grid

        ImageIcon icon = new ImageIcon("./Assets/jiggly.png"); // Load the image

        // Add 20 labels with text
        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel(icon);
            // JLabel label = new JLabel("Label " + (i + 1));
            add(label);
        }
    }
}