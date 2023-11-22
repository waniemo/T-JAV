package Pokemon;
import Attaques.AquaJet;
import Attaques.BulledO;
import Attaques.ComboGriffes;
import Attaques.Hydrocanon;
import Type.Eau;
import Type.Type;

import java.util.Arrays;

public class Musteflott extends Pokemon{
    public Musteflott() {
        super("Musteflott", Eau.class, 1, 95, 85, 85, 115, "musteflott.png", "musteflott_f.png", "musteflott_b.png", 82, 95.5, 95.5, 17, Arrays.asList(new ComboGriffes(), new AquaJet(), new BulledO(), new Hydrocanon()));
    }
}
