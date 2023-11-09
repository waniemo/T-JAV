package Pokemon;
import Type.Electrik;

public class Pachirisu extends Pokemon{
    public Pachirisu() {
        super("Pachirisu", Electrik.class, 1, 60, 45, 70, 95, "pachirisu.png", "pachirisu_f.gif", "pachirisu_b.gif");
    }

    Electrik electrik = new Electrik();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        electrik.attack(attack, ennemi, this);
        System.out.println(electrik.getAttacks());
    }
}
