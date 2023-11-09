package Pokemon;
import Type.Eau;
public class Moustillon extends Pokemon{
    public Moustillon() {
        super("Moustillon", Eau.class, 1, 50, 40, 40, 64, "moustillon.png", "moustillon_f.gif", "moustillon_b.gif");
    }
    Eau eau = new Eau();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        eau.attack(attack, ennemi, this);
        System.out.println(eau.getAttacks());
    }
}
