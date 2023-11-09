package Pokemon;
import Type.Fee;
import Type.Plante;

public class Doudouvet extends Pokemon{
    public Doudouvet() {
        super("Doudouvet", Fee.class, 1, 40, 27, 60, 66, "doudouvet.png", "doudouvet_f.gif", "doudouvet_b.gif");
    }

    Fee fee = new Fee();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        fee.attack(attack, ennemi, this);
        System.out.println(fee.getAttacks());
    }
}
