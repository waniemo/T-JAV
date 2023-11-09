package Pokemon;
import Type.Feu;

public class Ponyta extends Pokemon{
    public Ponyta() {
        super("Ponyta", Feu.class, 1, 50, 85, 55, 90, "ponyta.png", "ponyta_f.gif", "ponyta_b.gif");
    }

    Feu feu = new Feu();
    @Override
    public void attack(String attack, Pokemon ennemi) {
        feu.attack(attack, ennemi, this);
        System.out.println(feu.getAttacks());
    }
}
