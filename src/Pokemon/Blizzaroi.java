package Pokemon;

import Type.Plante;
import Type.Plante;

public class Blizzaroi extends Pokemon{
    public Blizzaroi() {
        super("Blizzaroi", Plante.class, 1, 90, 92, 75, 60, "blizzaroi.png", "blizzaroi_f.gif", "blizzaroi_b.gif");
    }

    Plante plante = new Plante();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        plante.attack(attack, ennemi, this);
        System.out.println(plante.getAttacks());
    }
}
