package Pokemon;
import Type.Fee;
public class Rondoudou extends Pokemon{
    public Rondoudou() {
        super("Rondoudou", Fee.class, 1, 115, 45, 20, 20, "rondoudou.png", "rondoudou_f.gif", "rondoudou_b.gif");
    }

    Fee fee = new Fee();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        fee.attack(attack, ennemi, this);
        System.out.println(fee.getAttacks());
    }
}
