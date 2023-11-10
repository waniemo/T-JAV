package Type;

import Pokemon.Pokemon;

public class Fee extends Type{
    public Fee() {
        super("Type.Fee", Plante.class, Feu.class);
        attacks.put("Câlinerie", 15);
        attacks.put("Vent Féérique", 10);
        attacks.put("Éclat Magique", 5);
    }

    @Override
    public String attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Câlinerie":
                if(attacks.get("Câlinerie") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Câlinerie !";
                } else {
                    attackMultiplier(5.5,1.5,3, ennemi, player);
                    attacks.put("Câlinerie", attacks.get("Câlinerie") - 1);
                    return player.getName()+" utilise Câlinerie !";
                }
            case "Vent Féérique":
                if(attacks.get("Vent Féérique") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Vent Féérique !";
                } else {
                    attackMultiplier(10,3,6, ennemi, player);
                    attacks.put("Vent Féérique", attacks.get("Vent Féérique") - 1);
                    return player.getName()+" utilise Vent Féérique !";
                }
            case "Éclat Magique":
                if(attacks.get("Éclat Magique") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Éclat Magique !";
                } else {
                    attackMultiplier(20.5,6,8, ennemi, player);
                    attacks.put("Éclat Magique", attacks.get("Éclat Magique") - 1);
                    return player.getName()+" utilise Éclat Magique !";
                }
        }
        return "";
    }
}
