package Pokemon;
import Type.Fee;

public class Kirby extends Pokemon{
    public Kirby() {
        super("Kirby", Fee.class, 1, 555, 555, 100, 100, "kirby.png", "kirby_f.gif", "kirby_b.gif");
    }

    Fee fee = new Fee();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        fee.attack(attack, ennemi, this);
        System.out.println(fee.getAttacks());
    }
}
