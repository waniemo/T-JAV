package Pokemon;
import Type.Eau;
public class Magicarpe extends Pokemon{
    public Magicarpe() {
        super("Magicarpe", Eau.class, 1, 20, 10, 55, 80, "magicarpe.png", "magicarpe_f.gif", "magicarpe_b.gif");
    }

    Eau eau = new Eau();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        eau.attack(attack, ennemi, this);
        System.out.println(eau.getAttacks());
    }
}
