import java.util.*;


public abstract class Type {
    protected String name;
    protected Class<? extends Type> strength;
    protected Class<? extends Type> weakness;
    protected HashMap<String, Integer> attacks = new HashMap<>();

    public Type(String name, Class<? extends Type> strength, Class<? extends Type> weakness){
        this.name = name;
        this.strength = strength;
        this.weakness = weakness;
    }

    public String getName() {
        return name;
    }

    public Class<? extends Type> getStrength() {
        return strength;
    }

    public Class<? extends Type> getWeakness() {
        return weakness;
    }

    public HashMap<String, Integer> getAttacks() {
        return attacks;
    }

    public abstract void attack(String attack, Pokemon ennemi, Pokemon player);

    public void attackMultiplier(double highMultiplier, double lowMultiplier, double mediumMultiplier, Pokemon ennemi, Pokemon player){
        if(ennemi.getType() == this.strength){
            ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + highMultiplier))));
            System.out.println("Cette attaque était très efficace !");
        }
        else if(ennemi.getType() == this.weakness){
            ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + lowMultiplier))));
            System.out.println("Cette attaque n'était pas très efficace...");
        }
        else{
            ennemi.setPv((int) (ennemi.getPv() - (((2.0 * player.getLevel() / 5.0 + 2.0) * (player.getAtk() / player.getDef()) / 50.0 + mediumMultiplier))));
        }
    }
}
