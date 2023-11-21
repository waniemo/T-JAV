package gui;

import javax.swing.SwingWorker;

import Item.Potion;
import Pokemon.Pokemon;
import Team.Team;

public class EnemyAI {
    public static void enemyAttack(ArenaPanel arena, Team playerTeam, Team enemyTeam) {
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
                    if (enemyPokemon.getPv() < enemyPokemon.getPvMax() / 2 && randomHeal == 1 && enemyTeam.getLevel()>30) {
                        Integer quantity = enemyTeam.getItems().get(Potion.class);
                        if (quantity != null && quantity > 0) {
                            enemyTeam.useItems(Potion.class.getDeclaredConstructor().newInstance(), enemyPokemon);
                            isHeal = true;
                        }
                        arena.setTextBoxLabel(enemyPokemon.getName() + " ennemi utilise une potion et se soigne !");
                    }
                    if (isHeal == false && enemyPokemon.getType() == playerPokemon.getType().getDeclaredConstructor()
                            .newInstance().getStrength() && enemyPokemon.getPv() < enemyPokemon.getPvMax() / 2 && enemyTeam.getLevel()>60) {
                        for (int i = 0; i < enemyTeam.getTeam().size(); i++) {
                            if (!enemyTeam.getDeadPokemons().contains(enemyTeam.getTeam().get(i))
                                    && enemyTeam.getTeam().get(i) != enemyPokemon) {
                                enemyTeam.setActivePokemon(enemyTeam.getTeam().get(i));
                                arena.setTextBoxLabel(
                                        "L'ennemi envoie " + enemyTeam.getActivePokemon().getName() + " !");
                                isHeal = true;
                                break;
                            }
                        }
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
