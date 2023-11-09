package Pokemon;
import Type.Eau;

public class Psykokwak extends Pokemon{
    public Psykokwak() {
        super("Psykokwak", Eau.class, 1, 50, 52, 48, 55, "psykokwak.png", "psykokwak_f.gif", "psykokwak_b.gif");
    }

    Eau eau = new Eau();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        eau.attack(attack, ennemi, this);
        System.out.println(eau.getAttacks());
    }
}
