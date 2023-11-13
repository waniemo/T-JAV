package Pokemon;
import Attaques.AquaJet;
import Attaques.BulledO;
import Attaques.ComboGriffes;
import Attaques.Hydrocanon;
import Type.Eau;
import Type.Type;

import java.util.Arrays;

public class Magicarpe extends Pokemon{
    public Magicarpe() {
        super("Magicarpe", Eau.class, 1, 20, 10, 55, 80, "magicarpe.png", "magicarpe_f.gif", "magicarpe_b.gif", Arrays.asList(new ComboGriffes(), new AquaJet(), new BulledO(), new Hydrocanon()));
    }

}
