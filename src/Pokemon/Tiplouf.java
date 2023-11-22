package Pokemon;
import Attaques.AquaJet;
import Attaques.BulledO;
import Attaques.ComboGriffes;
import Attaques.Hydrocanon;
import Type.Eau;
import Type.Type;

import java.util.Arrays;

public class Tiplouf extends Pokemon{
    public Tiplouf() {
        super("Tiplouf", Eau.class, 1, 53, 51, 53, 100, "tiplouf.png", "tiplouf_f.png", "tiplouf_b.png",49,49.2,42.2,10, Arrays.asList(new ComboGriffes(), new AquaJet(), new BulledO(), new Hydrocanon()));
    }
}
