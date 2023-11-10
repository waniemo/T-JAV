package Type;

import Pokemon.Pokemon;

public class Plante extends Type{
    public Plante() {
        super("Type.Plante", Electrik.class, Feu.class);
        attacks.put("Tranch'Herbe", 15);
        attacks.put("Tempêteverte", 10);
        attacks.put("Phytomixeur", 5);
    }
    @Override
    public String attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Tranch'Herbe":
                if(attacks.get("Tranch'Herbe") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Tranch'Herbe !";
                } else{
                    attackMultiplier(5.5,1.5,3, ennemi, player);
                    attacks.put("Tranch'Herbe", attacks.get("Tranch'Herbe") - 1);
                    return player.getName()+" utilise Tranch'Herbe !";
                }
            case "Tempêteverte":
                if(attacks.get("Tempêteverte") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Tempêteverte !";
                } else{
                    attackMultiplier(10,3,6, ennemi, player);
                    attacks.put("Tempêteverte", attacks.get("Tempêteverte") - 1);
                    return player.getName()+" utilise Tempêteverte !";
                }
            case "Phytomixeur":
                if(attacks.get("Phytomixeur") == 0){
                    return "Vous n'avez pas assez de PP pour utiliser Phytomixeur !";
                } else{
                    attackMultiplier(20.5,6,8, ennemi, player);
                    attacks.put("Phytomixeur", attacks.get("Phytomixeur") - 1);
                    return player.getName()+" utilise Phytomixeur !";
                }
        }
        return "";
    }
}
