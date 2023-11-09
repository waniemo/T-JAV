package Pokemon;

import Pokemon.Pokemon;
import Type.Fee;
import Type.Feu;

public class Hericendre extends Pokemon {

    public Hericendre() {
        super("Héricendre", Feu.class, 1, 39, 52, 43, 65, "hericendre.png", "hericendre_f.gif", "hericendre_b.gif");
    }

    Feu feu = new Feu();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        feu.attack(attack, ennemi, this);
        System.out.println(feu.getAttacks());
    }
}
