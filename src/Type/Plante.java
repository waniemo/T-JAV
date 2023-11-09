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
    public void attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Tranch'Herbe":
                if(attacks.get("Tranch'Herbe") == 0){
                    System.out.println("Vous n'avez pas assez de PP pour utiliser Tranch'Herbe !");
                    break;
                } else{
                    System.out.println(player.getName()+" utilise Tranch'Herbe !");
                    attackMultiplier(5.5,1.5,3, ennemi, player);
                    attacks.put("Tranch'Herbe", attacks.get("Tranch'Herbe") - 1);
                    break;
                }
            case "Tempêteverte":
                if(attacks.get("Tempêteverte") == 0){
                    System.out.println("Vous n'avez pas assez de PP pour utiliser Tempêteverte !");
                    break;
                } else{
                    System.out.println(player.getName()+" utilise Tempêteverte !");
                    attackMultiplier(10,3,6, ennemi, player);
                    attacks.put("Tempêteverte", attacks.get("Tempêteverte") - 1);
                    break;
                }
            case "Phytomixeur":
                if(attacks.get("Phytomixeur") == 0){
                    System.out.println("Vous n'avez pas assez de PP pour utiliser Phytomixeur !");
                    break;
                } else{
                    System.out.println(player.getName()+" utilise Phytomixeur !");
                    attackMultiplier(20.5,6,8, ennemi, player);
                    attacks.put("Phytomixeur", attacks.get("Phytomixeur") - 1);
                    break;
                }
        }
    }
}
