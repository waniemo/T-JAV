package Pokemon;
import Type.Eau;

public class Tiplouf extends Pokemon{
    public Tiplouf() {
        super("Tiplouf", Eau.class, 1, 53, 51, 53, 100, "tiplouf.png", "tiplouf_f.gif", "tiplouf_b.gif");
    }

    Eau eau = new Eau();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        eau.attack(attack, ennemi, this);
        System.out.println(eau.getAttacks());
    }
}
