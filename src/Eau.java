import java.util.Arrays;

public class Eau extends Type{
    public Eau() {
        super("Eau", Feu.class, Plante.class);
        attacks.put("Aqua-jet", 15);
        attacks.put("Bulle d'O", 10);
        attacks.put("Hydrocanon", 5);
    }
    @Override
    public void attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Aqua-jet":
                System.out.println(player.getName()+" utilise Aqua-jet !");
                if(ennemi.getType() == this.strength){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                }
                else if(ennemi.getType() == this.weakness){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 0.5))));
                }
                else{
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1))));
                }
                attacks.put("Aqua-jet", attacks.get("Aqua-jet") - 1);
                break;
            case "Bulle d'O":
                System.out.println(player.getName()+" utilise Bulle d'O !");
                if(ennemi.getType() == this.strength){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 5.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1.5))));
                } else {
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 3))));
                }
                attacks.put("Bulle d'O", attacks.get("Bulle d'O") - 1);
                break;
            case "Hydrocanon":
                System.out.println(player.getName()+" utilise Hydrocanon !");
                if (ennemi.getType() == this.strength){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 8.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                } else {
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 6))));
                }
                attacks.put("Hydrocanon", attacks.get("Hydrocanon") - 1);
                break;
        }
    }
}
