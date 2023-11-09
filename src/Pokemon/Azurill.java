package Pokemon;
import Type.Fee;

public class Azurill extends Pokemon{
    public Azurill() {
        super("Azurill", Fee.class, 1, 50, 20, 40, 20, "azurill.png", "azurill_f.gif", "azurill_b.gif");
    }
    Fee fee = new Fee();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        fee.attack(attack, ennemi, this);
        System.out.println(fee.getAttacks());
    }
}
