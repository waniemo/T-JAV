package gui;

import Team.*;

import javax.swing.*;
import java.awt.*;

public class ArenaPanel extends JPanel {
    public ArenaPanel(JFrame frame, Team playerTeam, Team enemyTeam) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel playerTeamPanel = new JPanel();
        playerTeamPanel.setBackground(Color.BLUE);
        JPanel enemyTeamPanel = new JPanel();
        enemyTeamPanel.setBackground(Color.RED);
        playerTeam.setActivePokemon(playerTeam.getTeam().get(0));
        enemyTeam.setActivePokemon(enemyTeam.getTeam().get(0));

        // BufferedImage playerDimg = null;
        // BufferedImage enemyDimg = null;
        // try {
        //     playerDimg = ImageIO
        //             .read(new File("../Assets/" + playerTeam.getActivePokemon().getSpriteBack()));
        //     enemyDimg = ImageIO
        //             .read(new File("../Assets/" + enemyTeam.getActivePokemon().getSpriteFront()));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // Image playerPokemonSprite = playerDimg.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        // Image enemyPokemonSprite = enemyDimg.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        // ImageIcon playerPokemonSpriteIcon = new ImageIcon(playerPokemonSprite);
        // ImageIcon enemyPokemonSpriteIcon = new ImageIcon(enemyPokemonSprite);


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(playerTeamPanel, gbc);

        // Bottom right panel
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(enemyTeamPanel, gbc);

        // Bottom left panel with 3 buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints buttonGbc = new GridBagConstraints();
        for (int i = 0; i < 3; i++) {
            buttonGbc.gridy = i;
            buttonPanel.add(new JButton("Button " + (i + 1)), buttonGbc);
        }
        add(buttonPanel, gbc);

        // Center left ImageIcon
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel(new ImageIcon("../Assets/" + playerTeam.getActivePokemon().getSpriteBack())), gbc);

        // Center right ImageIcon
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(new JLabel(new ImageIcon("../Assets/" + enemyTeam.getActivePokemon().getSpriteFront())), gbc);
    }
}
