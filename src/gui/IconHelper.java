package gui;

import Team.*;

import javax.swing.*;

public class IconHelper {
    public static JLabel createTeamIcon(Team team, boolean isPlayer) {
        String sprite = isPlayer ? team.getActivePokemon().getSpriteBack() : team.getActivePokemon().getSpriteFront();
        return new JLabel(new ImageIcon("Assets/" + sprite));
    }
}