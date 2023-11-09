package Pokemon;
import Type.Electrik;

public class Electhor extends Pokemon{
    public Electhor() {
        super("Electhor", Electrik.class, 1, 90, 90, 90, 100, "electhor.png", "electhor_f.gif", "electhor_b.gif");
    }

    Electrik electrik = new Electrik();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        electrik.attack(attack, ennemi, this);
        System.out.println(electrik.getAttacks());
    }
}
