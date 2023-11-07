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
                if(ennemi.getType() == this.strength){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                }
                else if(ennemi.getType() == this.weakness){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 0.5))));
                }
                else{
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1))));
                }
                attacks.put("Tacle Feu", attacks.get("Tacle Feu") - 1);
                break;
            case "Rafale Feu":
                System.out.println(player.getName()+" utilise Rafale Feu !");
                if(ennemi.getType() == this.strength){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 5.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 1.5))));
                } else {
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 3))));
                }
                attacks.put("Rafale Feu", attacks.get("Rafale Feu") - 1);
                break;
            case "Feu d'Enfer":
                System.out.println(player.getName()+" utilise Feu d'Enfer !");
                if (ennemi.getType() == this.strength){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 8.5))));
                } else if (ennemi.getType() == this.weakness){
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 2.5))));
                } else {
                    ennemi.setHp((int) (ennemi.getHp() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + 6))));
                }
                attacks.put("Feu d'Enfer", attacks.get("Feu d'Enfer") - 1);
                break;
        }
    }
}
