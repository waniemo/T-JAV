public class Fee extends Type{
    public Fee() {
        super("Fee", Plante.class, Feu.class);
        attacks.put("Câlinerie", 15);
        attacks.put("Vent Féérique", 10);
        attacks.put("Éclat Magique", 5);
    }
    @Override
    public void attack(String attack, Pokemon ennemi, Pokemon player) {
        switch(attack){
            case "Câlinerie":
                System.out.println( player.getName()+" utilise Câlinerie !");
                if(ennemi.getType() == this.strength){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                }
                else if(ennemi.getType() == this.weakness){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 0.5))));
                }
                else{
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1))));
                }
                attacks.put("Câlinerie", attacks.get("Câlinerie") - 1);
                break;
            case "Vent Féérique":
                System.out.println(player.getName()+" utilise Vent Féérique !");
                if(ennemi.getType() == this.strength){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 5.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1.5))));
                } else {
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 3))));
                }
                attacks.put("Vent Féérique", attacks.get("Vent Féérique") - 1);
                break;
            case "Éclat Magique":
                System.out.println(player.getName()+" utilise Éclat Magique !");
                if (ennemi.getType() == this.strength){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 8.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                } else {
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 6))));
                }
                attacks.put("Éclat Magique", attacks.get("Éclat Magique") - 1);
                break;
        }
    }
}
