package Pokemon;
import Type.Fee;

public class Gardevoir extends Pokemon{
    public Gardevoir() {
        super("Gardevoir", Fee.class, 1, 68, 65, 65, 80, "gardevoir.png", "gardevoir_f.gif", "gardevoir_b.gif");
    }

    Fee fee = new Fee();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        fee.attack(attack, ennemi, this);
        System.out.println(fee.getAttacks());
    }
}
