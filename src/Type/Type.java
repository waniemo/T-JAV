package Type;

import Pokemon.Pokemon;

import java.util.*;


public abstract class Type {
    protected String name;
    protected Class<? extends Type> strength;
    protected Class<? extends Type> weakness;

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

}
