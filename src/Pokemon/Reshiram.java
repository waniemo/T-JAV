package Pokemon;
import Type.Feu;

public class Reshiram extends Pokemon{
    public Reshiram() {
        super("Reshiram", Feu.class, 1, 100, 120, 100, 90, "reshiram.png", "reshiram_f.gif", "reshiram_b.gif");
    }

    Feu feu = new Feu();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        feu.attack(attack, ennemi, this);
        System.out.println(feu.getAttacks());
    }
}
