package Pokemon;

import Type.Electrik;

public class Voltorbe extends Pokemon{
    public Voltorbe() {
        super("Voltorbe", Electrik.class, 1, 40, 30, 50, 100, "voltorbe.png", "voltorbe_f.gif", "voltorbe_b.gif");
    }

    Electrik electrik = new Electrik();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        electrik.attack(attack, ennemi, this);
        System.out.println(electrik.getAttacks());
    }
}
