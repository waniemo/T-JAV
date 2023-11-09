package Pokemon;
import Type.Eau;

public class Musteflott extends Pokemon{
    public Musteflott() {
        super("Musteflott", Eau.class, 1, 95, 85, 85, 115, "musteflott.png", "musteflott_f.gif", "musteflott_b.gif");
    }

    Eau eau = new Eau();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        eau.attack(attack, ennemi, this);
        System.out.println(eau.getAttacks());
    }
}
