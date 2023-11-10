package Type;

import Pokemon.Pokemon;

public class Eau extends Type{
    public Eau() {
        super("Type.Eau", Feu.class, Plante.class);
        attacks.put("Aqua-jet", 15);
        attacks.put("Bulle d'O", 10);
        attacks.put("Hydrocanon", 5);
    }
    @Override
    public String attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Aqua-jet":
                if(attacks.get("Aqua-jet") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Aqua-jet !";
                } else{
                    attackMultiplier(5.5,1.5,3, ennemi, player);
                    attacks.put("Aqua-jet", attacks.get("Aqua-jet") - 1);
                    return player.getName()+" utilise Aqua-jet !";
                }
            case "Bulle d'O":
                if(attacks.get("Bulle d'O") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Bulle d'O !";
                } else{
                    attackMultiplier(10,3,6, ennemi, player);
                    attacks.put("Bulle d'O", attacks.get("Bulle d'O") - 1);
                    return player.getName()+" utilise Bulle d'O !";
                }
            case "Hydrocanon":
                if(attacks.get("Hydrocanon") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Hydrocanon !";
                } else{
                    attackMultiplier(20.5,6,8, ennemi, player);
                    attacks.put("Hydrocanon", attacks.get("Hydrocanon") - 1);
                    return player.getName()+" utilise Hydrocanon !";
                }
        }
        return "";
    }
}
