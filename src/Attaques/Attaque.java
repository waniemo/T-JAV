package Attaques;

public abstract class Attaque {
    protected String name;
    protected int pp;

    protected int ppMax;

    public Attaque(String name, int pp){
        this.name = name;
        this.pp = pp;
        ppMax = pp;
    }


    public String getName() {
        return name;
    }

    public int getPp() {
        return pp;
    }

    public int getPpMax() {
        return ppMax;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
