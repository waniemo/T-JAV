package Pokemon;
import Type.Plante;
public class Noadkoko extends Pokemon{
    public Noadkoko() {
        super("Noadkoko", Plante.class, 1, 60, 55, 90, 80, "noadkoko.png", "noadkoko_f.gif", "noadkoko_b.gif");
    }

    Plante plante = new Plante();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        plante.attack(attack, ennemi, this);
        System.out.println(plante.getAttacks());
    }
}
