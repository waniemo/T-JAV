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
    public void attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Câlinerie":
                if(attacks.get("Câlinerie") == 0){
                    System.out.println("Vous n'avez pas assez de PP pour utiliser Câlinerie !");
                    break;
                } else {
                    System.out.println(player.getName()+" utilise Câlinerie !");
                    attackMultiplier(5.5,1.5,3, ennemi, player);
                    attacks.put("Câlinerie", attacks.get("Câlinerie") - 1);
                    break;
                }
            case "Vent Féérique":
                if(attacks.get("Vent Féérique") == 0){
                    System.out.println("Vous n'avez pas assez de PP pour utiliser Vent Féérique !");
                    break;
                } else {
                    System.out.println(player.getName()+" utilise Vent Féérique !");
                    attackMultiplier(10,3,6, ennemi, player);
                    attacks.put("Vent Féérique", attacks.get("Vent Féérique") - 1);
                    break;
                }
            case "Éclat Magique":
                if(attacks.get("Éclat Magique") == 0){
                    System.out.println("Vous n'avez pas assez de PP pour utiliser Éclat Magique !");
                    break;
                } else {
                    System.out.println(player.getName()+" utilise Éclat Magique !");
                    attackMultiplier(20.5,6,8, ennemi, player);
                    attacks.put("Éclat Magique", attacks.get("Éclat Magique") - 1);
                    break;
                }
        }
    }
}
