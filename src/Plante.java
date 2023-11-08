public class Plante extends Type{
    public Plante() {
        super("Plante", Electrik.class, Feu.class);
        attacks.put("Tranch'Herbe", 15);
        attacks.put("Tempêteverte", 10);
        attacks.put("Phytomixeur", 5);
    }
    @Override
    public void attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Tranch'Herbe":
                System.out.println( player.getName()+" utilise Tranch'Herbe !");
                attackMultiplier(2.5,0.5,1, ennemi, player);
                attacks.put("Tranch'Herbe", attacks.get("Tranch'Herbe") - 1);
                break;
            case "Tempêteverte":
                System.out.println(player.getName()+" utilise Tempêteverte !");
                attackMultiplier(5.5,1.5,3, ennemi, player);
                attacks.put("Tempêteverte", attacks.get("Tempêteverte") - 1);
                break;
            case "Phytomixeur":
                System.out.println(player.getName()+" utilise Phytomixeur !");
                attackMultiplier(8.5,1.5,6, ennemi, player);
                attacks.put("Phytomixeur", attacks.get("Phytomixeur") - 1);
                break;
        }
    }
}
