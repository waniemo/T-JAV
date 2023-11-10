package Type;

import Pokemon.Pokemon;

public class Electrik extends Type{
    public Electrik() {
        super("Electrique", Eau.class, Plante.class);
        attacks.put("Eclair", 15);
        attacks.put("Cage-Eclair", 10);
        attacks.put("Fatal-Foudre", 5);
    }
    @Override
    public String attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Eclair":
                if(attacks.get("Eclair") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Eclair !";
                } else{
                    attackMultiplier(5.5,1.5,3, ennemi, player);
                    attacks.put("Eclair", attacks.get("Eclair") - 1);
                    return player.getName()+" utilise Eclair !";
                }
            case "Cage-Eclair":
                if(attacks.get("Cage-Eclair") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Cage-Eclair !";
                } else{
                    attackMultiplier(10,3,6, ennemi, player);
                    attacks.put("Cage-Eclair", attacks.get("Cage-Eclair") - 1);
                    return player.getName()+" utilise Cage-Eclair !";
                }
            case "Fatal-Foudre":
                if(attacks.get("Fatal-Foudre") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Fatal-Foudre !";
                } else{
                    attackMultiplier(20.5,6,8, ennemi, player);
                    attacks.put("Fatal-Foudre", attacks.get("Fatal-Foudre") - 1);
                    return player.getName()+" utilise Fatal-Foudre !";
                }
        }
        return "";
    }
}
