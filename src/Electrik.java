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
                attackMultiplier(2.5,0.5,1, ennemi, player);
                attacks.put("Eclair", attacks.get("Eclair") - 1);
                break;
            case "Cage-Eclair":
                System.out.println(player.getName()+" utilise Cage-Eclair !");
                attackMultiplier(5.5,1.5,3, ennemi, player);
                attacks.put("Cage-Eclair", attacks.get("Cage-Eclair") - 1);
                break;
            case "Fatal-Foudre":
                System.out.println(player.getName()+" utilise Fatal-Foudre !");
                attackMultiplier(8.5,1.5,6, ennemi, player);
                attacks.put("Fatal-Foudre", attacks.get("Fatal-Foudre") - 1);
                break;
        }
    }
}
