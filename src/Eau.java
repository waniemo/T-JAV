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
                attackMultiplier(2.5,0.5,1, ennemi, player);
                attacks.put("Aqua-jet", attacks.get("Aqua-jet") - 1);
                break;
            case "Bulle d'O":
                System.out.println(player.getName()+" utilise Bulle d'O !");
                attackMultiplier(5.5,1.5,3, ennemi, player);
                attacks.put("Bulle d'O", attacks.get("Bulle d'O") - 1);
                break;
            case "Hydrocanon":
                System.out.println(player.getName()+" utilise Hydrocanon !");
                attackMultiplier(8.5,1.5,6, ennemi, player);
                attacks.put("Hydrocanon", attacks.get("Hydrocanon") - 1);
                break;
        }
    }
}
