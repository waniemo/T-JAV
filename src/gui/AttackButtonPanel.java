package gui;

import Pokemon.Pokemon;
import Team.Team;

import javax.swing.*;

import Item.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AttackButtonPanel extends JPanel {
    private static PlaySound sound = new PlaySound();
    private ImageIcon attaque1 = null;
    private ImageIcon retourIcon = null;

    public AttackButtonPanel(App frame, ArenaPanel arena, Team playerTeam, Team enemyTeam, JPanel buttonPanel, GridBagConstraints buttonGbc) {
        java.net.URL retourURL = ChooseTeamUI.class.getClassLoader().getResource("Assets/Bouton/bouton_retour.png");

        if (retourURL != null) {
            try (java.io.InputStream stream = retourURL.openStream()) {
                retourIcon = new ImageIcon(javax.imageio.ImageIO.read(stream));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Image not found: bouton_retour.png");
        }

        JLabel retourLabel = new JLabel(retourIcon);
        retourLabel.setText("Retour");
        retourLabel.setHorizontalTextPosition(JLabel.CENTER);
        retourLabel.setVerticalTextPosition(JLabel.CENTER);
        retourLabel.setForeground(Color.white);
        retourLabel.setFont(UIManager.getFont("Label.font").deriveFont(26f));

        java.net.URL imageURL = ChooseTeamUI.class.getClassLoader().getResource("Assets/Bouton/normal_attaque.png");

        if (imageURL != null) {
            try (java.io.InputStream stream = imageURL.openStream()) {
                attaque1 = new ImageIcon(javax.imageio.ImageIO.read(stream));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Image not found: text_box.png");
        }

        ArrayList<JLabel> attaqueLabels = new ArrayList<>();
        JLabel attaqueLabel1 = new JLabel(attaque1);
        JLabel attaqueLabel2 = new AttackButton(playerTeam, 1);
        JLabel attaqueLabel3 = new AttackButton(playerTeam, 2);
        JLabel attaqueLabel4 = new AttackButton(playerTeam, 3);
        attaqueLabels.add(attaqueLabel1);
        attaqueLabels.add(attaqueLabel2);
        attaqueLabels.add(attaqueLabel3);
        attaqueLabels.add(attaqueLabel4);

        for (int i = 0; i < 4; i++) {
            String PP = playerTeam.getActivePokemon().getAttaques().get(i).getName() + " "
                    + Integer.toString(playerTeam.getActivePokemon().getAttaques().get(i).getPp()) + "/"
                    + Integer.toString(playerTeam.getActivePokemon().getAttaques().get(i).getPpMax());
            attaqueLabels.get(i).setText(PP);
            attaqueLabels.get(i).setHorizontalTextPosition(JLabel.CENTER);
            attaqueLabels.get(i).setVerticalTextPosition(JLabel.CENTER);
            if (playerTeam.getActivePokemon().getAttaques().get(i).getPp() != 0) {
                attaqueLabels.get(i).setForeground(Color.white);
            } else {
                attaqueLabels.get(i).setForeground(Color.gray);

            }
            attaqueLabels.get(i).setFont(UIManager.getFont("Label.font").deriveFont(26f));
        }

        LayoutHelper.modifyGridBagConstraints(buttonGbc, 0, 0, buttonGbc.weighty, buttonGbc.weightx);
        buttonPanel.add(attaqueLabel1, buttonGbc);

        LayoutHelper.modifyGridBagConstraints(buttonGbc, 1, 0, buttonGbc.weighty, buttonGbc.weightx);
        buttonPanel.add(attaqueLabel2, buttonGbc);

        LayoutHelper.modifyGridBagConstraints(buttonGbc, 0, 1, buttonGbc.weighty, buttonGbc.weightx);
        buttonPanel.add(attaqueLabel3, buttonGbc);

        LayoutHelper.modifyGridBagConstraints(buttonGbc, 1, 1, buttonGbc.weighty, buttonGbc.weightx);
        buttonPanel.add(attaqueLabel4, buttonGbc);

        LayoutHelper.modifyGridBagConstraints(buttonGbc, 2, 1, buttonGbc.weighty, buttonGbc.weightx);
        buttonPanel.add(retourLabel, buttonGbc);

        retourLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonPanel.removeAll();
                buttonPanel.revalidate();
                buttonPanel.repaint();
                sound.playSound("button", frame.hasSound());
                JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                buttonPanel.add(menuButtons);
            }
        });

        if (playerTeam.getActivePokemon().getAttaques().get(0).getPp() != 0) {
            attaqueLabel1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    sound.playSound("button", frame.hasSound());
                    System.out.println(enemyTeam.getActivePokemon().getPv());
                    playerTeam.getActivePokemon().attaqueNormale(enemyTeam.getActivePokemon());
                    System.out.println(enemyTeam.getActivePokemon().getPv());
                    arena.setTextBoxLabel(playerTeam.getActivePokemon().getName() + " utilise "
                            + playerTeam.getActivePokemon().getAttaques().get(0).getName() + " !");
                    EnemyAI.enemyAttack(arena, playerTeam, enemyTeam);
                    buttonPanel.removeAll();
                    buttonPanel.revalidate();
                    buttonPanel.repaint();
                    JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                    buttonPanel.add(menuButtons);
                }
            });
        }

        if (playerTeam.getActivePokemon().getAttaques().get(1).getPp() != 0) {
            attaqueLabel2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    sound.playSound("button", frame.hasSound());

                    System.out.println(enemyTeam.getActivePokemon().getPv());
                    try {
                        playerTeam.getActivePokemon().attaqueType1(enemyTeam.getActivePokemon());
                    } catch (NoSuchMethodException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println(enemyTeam.getActivePokemon().getPv());
                    arena.setTextBoxLabel(playerTeam.getActivePokemon().getName() + " utilise "
                            + playerTeam.getActivePokemon().getAttaques().get(1).getName() + " !");
                    EnemyAI.enemyAttack(arena, playerTeam, enemyTeam);
                    buttonPanel.removeAll();
                    buttonPanel.revalidate();
                    buttonPanel.repaint();
                    JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                    buttonPanel.add(menuButtons);
                }
            });
        }

        if (playerTeam.getActivePokemon().getAttaques().get(2).getPp() != 0) {
            attaqueLabel3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    sound.playSound("button", frame.hasSound());

                    System.out.println(enemyTeam.getActivePokemon().getPv());
                    try {
                        playerTeam.getActivePokemon().attaqueType2(enemyTeam.getActivePokemon());
                    } catch (NoSuchMethodException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println(enemyTeam.getActivePokemon().getPv());
                    arena.setTextBoxLabel(playerTeam.getActivePokemon().getName() + " utilise "
                            + playerTeam.getActivePokemon().getAttaques().get(2).getName() + " !");
                    EnemyAI.enemyAttack(arena, playerTeam, enemyTeam);
                    buttonPanel.removeAll();
                    buttonPanel.revalidate();
                    buttonPanel.repaint();
                    JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                    buttonPanel.add(menuButtons);
                }
            });
        }

        if (playerTeam.getActivePokemon().getAttaques().get(3).getPp() != 0) {
            attaqueLabel4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    sound.playSound("button", frame.hasSound());

                    System.out.println(enemyTeam.getActivePokemon().getPv());
                    arena.setTextBoxLabel(playerTeam.getActivePokemon().getName() + " utilise "
                            + playerTeam.getActivePokemon().getAttaques().get(3).getName() + " !");
                    try {
                        playerTeam.getActivePokemon().attaqueType3(enemyTeam.getActivePokemon());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println(enemyTeam.getActivePokemon().getPv());
                    EnemyAI.enemyAttack(arena, playerTeam, enemyTeam);
                    buttonPanel.removeAll();
                    buttonPanel.revalidate();
                    buttonPanel.repaint();
                    JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                    buttonPanel.add(menuButtons);
                }
            });
        }
    }
}
