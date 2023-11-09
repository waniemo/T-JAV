package Pokemon;
import Type.Feu;
public class Simiabraz extends Pokemon{
    public Simiabraz() {
        super("Simiabraz", Feu.class , 1, 76, 104, 71, 108, "simiabraz.png", "simiabraz_f.gif", "simiabraz_b.gif");
    }
    Feu feu = new Feu();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        feu.attack(attack, ennemi, this);
        System.out.println(feu.getAttacks());
    }
}
