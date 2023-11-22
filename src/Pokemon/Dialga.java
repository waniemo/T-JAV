package Pokemon;
import Attaques.AquaJet;
import Attaques.BulledO;
import Attaques.ComboGriffes;
import Attaques.Hydrocanon;
import Type.Eau;
import Type.Type;

import java.util.Arrays;

public class Dialga extends Pokemon{
    public Dialga() {
        super("Dialga", Eau.class, 1, 100, 120, 120, 90, "dialga.png", "dialga_f.png", "dialga_b.png",95, 107, 107, 7, Arrays.asList(new ComboGriffes(), new AquaJet(), new BulledO(), new Hydrocanon()));
    }
}
