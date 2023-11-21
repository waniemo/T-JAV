package gui;

import javax.swing.*;

import Team.Team;

public class AttackButton extends JLabel {
    public AttackButton(Team playerTeam, int index) {
        ImageIcon attaque = null;
        try {
            if (playerTeam.getActivePokemon().getAttaques().get(index).getPp() > 0) {
                attaque = new ImageIcon(
                        "../Assets/Bouton/" + playerTeam.getActivePokemon().getType().getDeclaredConstructor()
                                .newInstance().getName().toLowerCase() + "_attaque.png");
            } else {
                attaque = new ImageIcon(
                        "../Assets/Bouton/noPP_attaque.png");
            }
        } catch (Exception exception) {
        }
        setIcon(attaque);
    }
}
