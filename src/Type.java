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

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(Class<? extends Type> strength) {
        this.strength = strength;
    }

    public void setWeakness(Class<? extends Type> weakness) {
        this.weakness = weakness;
    }

    public void setAttacks(HashMap<String, Integer> attacks) {
        this.attacks = attacks;
    }

    public abstract void attack(String attack, Pokemon ennemi, Pokemon player);
}
