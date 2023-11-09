package Pokemon;
import Type.Plante;
public class Haydam extends Pokemon{
    public Haydam() {
        super("Haydam", Plante.class, 1, 60, 70, 65, 125, "haydam.png", "haydam_f.gif", "haydam_b.gif");
    }
    Plante plante = new Plante();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        plante.attack(attack, ennemi, this);
        System.out.println(plante.getAttacks());
    }
}
