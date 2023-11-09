package Pokemon;
import Type.Eau;

public class Dialga extends Pokemon{
    public Dialga() {
        super("Dialga", Eau.class, 1, 100, 120, 120, 90, "dialga.png", "dialga_f.gif", "dialga_b.gif");
    }

    Eau eau = new Eau();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        eau.attack(attack, ennemi, this);
        System.out.println(eau.getAttacks());
    }
}
