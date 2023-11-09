package Type;

import Pokemon.Pokemon;

public class Feu extends Type{
    public Feu() {
        super("Type.Feu", Plante.class, Eau.class);
        attacks.put("Tacle Feu", 15);
        attacks.put("Rafale Feu", 10);
        attacks.put("Feu d'Enfer", 5);
    }
    @Override
    public void attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Tacle Feu":
                if(attacks.get("Tacle Feu") == 0){
                    System.out.println("Vous n'avez pas assez de PP pour utiliser Tacle Feu !");
                    break;
                } else{
                    System.out.println(player.getName()+" utilise Tacle Feu !");
                    attackMultiplier(5.5,1.5,3, ennemi, player);
                    attacks.put("Tacle Feu", attacks.get("Tacle Feu") - 1);
                    break;
                }
            case "Rafale Feu":
                if(attacks.get("Rafale Feu") == 0){
                    System.out.println("Vous n'avez pas assez de PP pour utiliser Rafale Feu !");
                    break;
                } else{
                    System.out.println(player.getName()+" utilise Rafale Feu !");
                    attackMultiplier(10,3,6, ennemi, player);
                    attacks.put("Rafale Feu", attacks.get("Rafale Feu") - 1);
                    break;
                }
            case "Feu d'Enfer":
                if(attacks.get("Feu d'Enfer") == 0){
                    System.out.println("Vous n'avez pas assez de PP pour utiliser Feu d'Enfer !");
                    break;
                } else{
                    System.out.println(player.getName()+" utilise Feu d'Enfer !");
                    attackMultiplier(20.5,6,8, ennemi, player);
                    attacks.put("Feu d'Enfer", attacks.get("Feu d'Enfer") - 1);
                    break;
                }
        }
    }
}
