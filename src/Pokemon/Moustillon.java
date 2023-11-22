package Pokemon;
import Attaques.AquaJet;
import Attaques.BulledO;
import Attaques.ComboGriffes;
import Attaques.Hydrocanon;
import Type.Eau;
import Type.Type;

import java.util.Arrays;

public class Moustillon extends Pokemon{
    public Moustillon() {
        super("Moustillon", Eau.class, 1, 50, 40, 40, 64, "moustillon.png", "moustillon_f.gif", "moustillon_b.gif",54,55.5,55.1,8, Arrays.asList(new ComboGriffes(), new AquaJet(), new BulledO(), new Hydrocanon()));
    }
}
