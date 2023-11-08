public class Feu extends Type{
    public Feu() {
        super("Feu", Plante.class, Eau.class);
        attacks.put("Tacle Feu", 15);
        attacks.put("Rafale Feu", 10);
        attacks.put("Feu d'Enfer", 5);
    }
    @Override
    public void attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Tacle Feu":
                System.out.println( player.getName()+" utilise Tacle Feu !");
                attackMultiplier(2.5,0.5,1, ennemi, player);
                attacks.put("Tacle Feu", attacks.get("Tacle Feu") - 1);
                break;
            case "Rafale Feu":
                System.out.println(player.getName()+" utilise Rafale Feu !");
                attackMultiplier(5.5,1.5,3, ennemi, player);
                attacks.put("Rafale Feu", attacks.get("Rafale Feu") - 1);
                break;
            case "Feu d'Enfer":
                System.out.println(player.getName()+" utilise Feu d'Enfer !");
                attackMultiplier(8.5,1.5,6, ennemi, player);
                attacks.put("Feu d'Enfer", attacks.get("Feu d'Enfer") - 1);
                break;
        }
    }
}
