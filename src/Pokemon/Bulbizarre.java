package Pokemon;
import Type.Plante;
public class Bulbizarre extends Pokemon{
    public Bulbizarre() {
        super("Bulbizarre", Plante.class, 1, 45, 49, 49, 45, "bulbizarre.png", "bulbizarre_f.gif", "bulbizarre_b.gif");
    }
    Plante plante = new Plante();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        plante.attack(attack, ennemi, this);
        System.out.println(plante.getAttacks());
    }
}
