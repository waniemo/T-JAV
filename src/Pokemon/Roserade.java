package Pokemon;
import Type.Plante;

public class Roserade extends Pokemon{
    public Roserade() {
        super("Roserade", Plante.class, 1, 60, 70, 65, 125, "roserade.png", "roserade_f.gif", "roserade_b.gif");
    }

    Plante plante = new Plante();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        plante.attack(attack, ennemi, this);
        System.out.println(plante.getAttacks());
    }
}
