package Pokemon;
import Type.Fee;
public class Togepi extends Pokemon{
    public Togepi() {
        super("Togepi", Fee.class, 1, 35, 20, 65, 40, "togepi.png", "togepi_f.gif", "togepi_b.gif");
    }
    Fee fee = new Fee();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        fee.attack(attack, ennemi, this);
        System.out.println(fee.getAttacks());
    }
}
