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
                if(ennemi.getType() == this.strength){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                }
                else if(ennemi.getType() == this.weakness){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 0.5))));
                }
                else{
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1))));
                }
                attacks.put("Tranch'Herbe", attacks.get("Tranch'Herbe") - 1);
                break;
            case "Tempêteverte":
                System.out.println(player.getName()+" utilise Tempêteverte !");
                if(ennemi.getType() == this.strength){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 5.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1.5))));
                } else {
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 3))));
                }
                attacks.put("Tempêteverte", attacks.get("Tempêteverte") - 1);
                break;
            case "Phytomixeur":
                System.out.println(player.getName()+" utilise Phytomixeur !");
                if (ennemi.getType() == this.strength){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 8.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                } else {
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 6))));
                }
                attacks.put("Phytomixeur", attacks.get("Phytomixeur") - 1);
                break;
        }
    }
}
