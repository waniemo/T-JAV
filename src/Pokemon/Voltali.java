package Pokemon;

import Type.Electrik;

public class Voltali extends Pokemon{
    public Voltali() {
        super("Voltali", Electrik.class, 1, 65, 65, 60, 130, "voltali.png", "voltali_f.gif", "voltali_b.gif");
    }

    Electrik electrik = new Electrik();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        electrik.attack(attack, ennemi, this);
        System.out.println(electrik.getAttacks());
    }
}
