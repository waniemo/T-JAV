package Attaques;

public abstract class Attaque {
    protected String name;
    protected int pp;

    public Attaque(String name, int pp){
        this.name = name;
        this.pp = pp;
    }


    public String getName() {
        return name;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
