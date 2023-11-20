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
    public AttackButtonPanel(App frame, ArenaPanel arena, Team playerTeam, Team enemyTeam, JPanel buttonPanel,
            GridBagConstraints buttonGbc) {
        ImageIcon retourIcon = new ImageIcon("../Assets/Bouton/bouton_retour.png");
        JLabel retourLabel = new JLabel(retourIcon);
        retourLabel.setText("Retour");
        retourLabel.setHorizontalTextPosition(JLabel.CENTER);
        retourLabel.setVerticalTextPosition(JLabel.CENTER);
        retourLabel.setForeground(Color.white);
        retourLabel.setFont(UIManager.getFont("Label.font").deriveFont(26f));
        ImageIcon attaque1 = new ImageIcon("../Assets/Bouton/normal_attaque.png");
        ImageIcon attaque2 = null;
        ImageIcon attaque3 = null;
        ImageIcon attaque4 = null;
        try {
            attaque2 = new ImageIcon("../Assets/Bouton/" + playerTeam.getActivePokemon().getType().getDeclaredConstructor()
                    .newInstance().getName().toLowerCase() + "_attaque.png");
            attaque3 = new ImageIcon("../Assets/Bouton/" + playerTeam.getActivePokemon().getType().getDeclaredConstructor()
                    .newInstance().getName().toLowerCase() + "_attaque.png");
            attaque4 = new ImageIcon("../Assets/Bouton/" + playerTeam.getActivePokemon().getType().getDeclaredConstructor()
                    .newInstance().getName().toLowerCase() + "_attaque.png");
        } catch (Exception exception) {
        }

        ArrayList<JLabel> attaqueLabels = new ArrayList<>();
        JLabel attaqueLabel1 = new JLabel(attaque1);
        JLabel attaqueLabel2 = new JLabel(attaque2);
        JLabel attaqueLabel3 = new JLabel(attaque3);
        JLabel attaqueLabel4 = new JLabel(attaque4);
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
            attaqueLabels.get(i).setForeground(Color.white);
            attaqueLabels.get(i).setFont(UIManager.getFont("Label.font").deriveFont(26f));
        }

        buttonGbc.gridx = 0;
        buttonGbc.gridy = 0;
        buttonPanel.add(attaqueLabel1, buttonGbc);

        buttonGbc.gridx = 1;
        buttonGbc.gridy = 0;
        buttonPanel.add(attaqueLabel2, buttonGbc);

        buttonGbc.gridx = 0;
        buttonGbc.gridy = 1;
        buttonPanel.add(attaqueLabel3, buttonGbc);

        buttonGbc.gridx = 1;
        buttonGbc.gridy = 1;
        buttonPanel.add(attaqueLabel4, buttonGbc);

        buttonGbc.gridx = 2;
        buttonGbc.gridy = 1;
        buttonPanel.add(retourLabel, buttonGbc);

        retourLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonPanel.removeAll();
                buttonPanel.revalidate();
                buttonPanel.repaint();
                PlaySound.playSound("button");
                JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                buttonPanel.add(menuButtons);
            }
        });

        attaqueLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlaySound.playSound("button");
                System.out.println(enemyTeam.getActivePokemon().getPv());
                playerTeam.getActivePokemon().attaqueNormale(enemyTeam.getActivePokemon());
                System.out.println(enemyTeam.getActivePokemon().getPv());
                arena.setTextBoxLabel(playerTeam.getActivePokemon().getName() + " utilise "
                        + playerTeam.getActivePokemon().getAttaques().get(0).getName() + " !");
                enemyAttack(arena, playerTeam, enemyTeam);
                buttonPanel.removeAll();
                buttonPanel.revalidate();
                buttonPanel.repaint();
                JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                buttonPanel.add(menuButtons);
            }
        });

        attaqueLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlaySound.playSound("button");

                System.out.println(enemyTeam.getActivePokemon().getPv());
                try {
                    playerTeam.getActivePokemon().attaqueType1(enemyTeam.getActivePokemon());
                } catch (NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(enemyTeam.getActivePokemon().getPv());
                arena.setTextBoxLabel(playerTeam.getActivePokemon().getName() + " utilise "
                        + playerTeam.getActivePokemon().getAttaques().get(1).getName() + " !");
                enemyAttack(arena, playerTeam, enemyTeam);
                buttonPanel.removeAll();
                buttonPanel.revalidate();
                buttonPanel.repaint();
                JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                buttonPanel.add(menuButtons);
            }
        });

        attaqueLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlaySound.playSound("button");

                System.out.println(enemyTeam.getActivePokemon().getPv());
                try {
                    playerTeam.getActivePokemon().attaqueType2(enemyTeam.getActivePokemon());
                } catch (NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(enemyTeam.getActivePokemon().getPv());
                arena.setTextBoxLabel(playerTeam.getActivePokemon().getName() + " utilise "
                        + playerTeam.getActivePokemon().getAttaques().get(2).getName() + " !");
                enemyAttack(arena, playerTeam, enemyTeam);
                buttonPanel.removeAll();
                buttonPanel.revalidate();
                buttonPanel.repaint();
                JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                buttonPanel.add(menuButtons);
            }
        });

        attaqueLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlaySound.playSound("button");

                System.out.println(enemyTeam.getActivePokemon().getPv());
                arena.setTextBoxLabel(playerTeam.getActivePokemon().getName() + " utilise "
                        + playerTeam.getActivePokemon().getAttaques().get(3).getName() + " !");
                try {
                    playerTeam.getActivePokemon().attaqueType3(enemyTeam.getActivePokemon());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(enemyTeam.getActivePokemon().getPv());
                enemyAttack(arena, playerTeam, enemyTeam);
                buttonPanel.removeAll();
                buttonPanel.revalidate();
                buttonPanel.repaint();
                JPanel menuButtons = PanelHelper.createButtonPanel(frame, arena, playerTeam, enemyTeam);
                buttonPanel.add(menuButtons);
            }
        });
    }

    private void enemyAttack(ArenaPanel arena, Team playerTeam, Team enemyTeam) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Pokemon enemyPokemon = enemyTeam.getActivePokemon();
                Pokemon playerPokemon = playerTeam.getActivePokemon();
                int randomAtk = (int) (Math.random() * 4);
                int randomHeal = (int) (Math.random() * 6);
                boolean isHeal = false;

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (enemyPokemon.getPv() > 0) {
                    if (enemyPokemon.getPv() < enemyPokemon.getPvMax() / 2 && randomHeal == 1) {
                        Integer quantity = enemyTeam.getItems().get(Potion.class);
                        if (quantity != null && quantity > 0) {
                            enemyTeam.useItems(Potion.class.getDeclaredConstructor().newInstance(), enemyPokemon);
                            isHeal = true;
                        }
                        arena.setTextBoxLabel(enemyPokemon.getName() + " ennemi utilise une potion et se soigne !");
                    }
                    if (isHeal == false) {
                        if (enemyPokemon.getAttaques().get(randomAtk).getPp() > 0) {
                            enemyPokemon.attaqueNormale(playerPokemon);
                            arena.setTextBoxLabel(enemyPokemon.getName() + " ennemi utilise "
                                    + enemyPokemon.getAttaques().get(randomAtk).getName() + " !");
                        } else {
                            enemyAttack(arena, playerTeam, enemyTeam);
                        }
                    }
                }
                return null;
            }
        };
        worker.execute();
    }
}
