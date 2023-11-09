package Pokemon;
import Type.Feu;

public class HoOh extends Pokemon{
    public HoOh() {
        super("Ho-Oh", Feu.class , 1, 130, 90, 110, 154, "hooh.png", "hooh_f.gif", "hooh_b.gif");
    }
    Feu feu = new Feu();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        feu.attack(attack, ennemi, this);
        System.out.println(feu.getAttacks());
    }
}
