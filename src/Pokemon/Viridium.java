package Pokemon;
import Type.Plante;
public class Viridium extends Pokemon{
    public Viridium() {
        super("Viridium", Plante.class, 1, 91, 90, 72, 108, "viridium.png", "viridium_f.gif", "viridium_b.gif");
    }

    Plante plante = new Plante();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        plante.attack(attack, ennemi, this);
        System.out.println(plante.getAttacks());
    }
}
