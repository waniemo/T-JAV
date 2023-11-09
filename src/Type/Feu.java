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
                System.out.println( player.getName()+" utilise Tacle Type.Feu !");
                attackMultiplier(5.5,1.5,3, ennemi, player);
                attacks.put("Tacle Type.Feu", attacks.get("Tacle Type.Feu") - 1);
                break;
            case "Rafale Feu":
                System.out.println(player.getName()+" utilise Rafale Type.Feu !");
                attackMultiplier(10,3,6, ennemi, player);
                attacks.put("Rafale Type.Feu", attacks.get("Rafale Type.Feu") - 1);
                break;
            case "Feu d'Enfer":
                System.out.println(player.getName()+" utilise Type.Feu d'Enfer !");
                attackMultiplier(20.5,6,8, ennemi, player);
                attacks.put("Type.Feu d'Enfer", attacks.get("Type.Feu d'Enfer") - 1);
                break;
        }
    }
}
