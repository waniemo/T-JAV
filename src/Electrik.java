import java.util.Arrays;
import java.util.HashMap;

public class Electrik extends Type{
    public Electrik() {
        super("Electrique", Eau.class, Plante.class);
        attacks.put("Eclair", 15);
        attacks.put("Cage-Eclair", 10);
        attacks.put("Fatal-Foudre", 5);
    }
    @Override
    public void attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Eclair":
                System.out.println( player.getName()+" utilise Eclair !");
                if(ennemi.getType() == this.strength){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                }
                else if(ennemi.getType() == this.weakness){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 0.5))));
                }
                else{
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1))));
                }
                attacks.put("Eclair", attacks.get("Eclair") - 1);
                break;
            case "Cage-Eclair":
                System.out.println(player.getName()+" utilise Cage-Eclair !");
                if(ennemi.getType() == this.strength){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 5.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1.5))));
                } else {
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 3))));
                }
                attacks.put("Cage-Eclair", attacks.get("Cage-Eclair") - 1);
                break;
            case "Fatal-Foudre":
                System.out.println(player.getName()+" utilise Fatal-Foudre !");
                if (ennemi.getType() == this.strength){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 8.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                } else {
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 6))));
                }
                attacks.put("Fatal-Foudre", attacks.get("Fatal-Foudre") - 1);
                break;
        }
    }
}
