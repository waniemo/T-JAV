package Pokemon;
import Type.Feu;

public class Lugulabre extends Pokemon{
    public Lugulabre() {
        super("Lugulabre", Feu.class, 1, 60, 55, 90, 80, "lugulabre.png", "lugulabre_f.gif", "lugulabre_b.gif");
    }

    Feu feu = new Feu();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        feu.attack(attack, ennemi, this);
        System.out.println(feu.getAttacks());
    }
}
