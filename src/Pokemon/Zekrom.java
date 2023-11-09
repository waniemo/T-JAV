package Pokemon;
import Type.Electrik;

public class Zekrom extends Pokemon{
    public Zekrom() {
        super("Zekrom", Electrik.class, 1, 100, 150, 120, 90, "zekrom.png", "zekrom_f.gif", "zekrom_b.gif");
    }

    Electrik electrik = new Electrik();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        electrik.attack(attack, ennemi, this);
        System.out.println(electrik.getAttacks());
    }

}
