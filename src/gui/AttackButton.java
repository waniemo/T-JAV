package gui;

import javax.swing.*;

import Team.Team;

public class AttackButton extends JLabel {
    private ImageIcon attaque = null;
    private java.net.URL imageURL = null;
    private java.net.URL imageURL2 = null;

    public AttackButton(Team playerTeam, int index) {
        try {
            imageURL = ChooseTeamUI.class.getClassLoader().getResource("Assets/Bouton/" + playerTeam.getActivePokemon()
                    .getType().getDeclaredConstructor().newInstance().getName().toLowerCase() + "_attaque.png");
        } catch (Exception exception) {
        }
        try {
            imageURL2 = ChooseTeamUI.class.getClassLoader().getResource("Assets/Bouton/noPP_attaque.png");
        } catch (Exception exception) {
        }

        if (imageURL != null) {
            try (java.io.InputStream stream = imageURL.openStream()) {
                if (playerTeam.getActivePokemon().getAttaques().get(index).getPp() > 0) {
                    attaque = new ImageIcon(javax.imageio.ImageIO.read(stream));
                } else {
                    try (java.io.InputStream stream2 = imageURL2.openStream()) {
                        attaque = new ImageIcon(javax.imageio.ImageIO.read(stream));
                    } catch (Exception exception2) {
                    }
                }
            } catch (Exception exception) {
            }
            setIcon(attaque);
        } else {
            System.err.println("Image not found: text_box.png");
        }
    }
}
