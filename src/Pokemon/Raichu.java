package Pokemon;

import Type.Electrik;
import Type.Feu;

public class Raichu extends Pokemon{
    public Raichu() {
        super("Raichu", Electrik.class, 1, 60, 90, 55, 110, "raichu.png", "raichu_f.gif", "raichu_b.gif");
    }

    Electrik electrik = new Electrik();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        electrik.attack(attack, ennemi, this);
        System.out.println(electrik.getAttacks());
    }
}
