package Pokemon;
import Attaques.AquaJet;
import Attaques.BulledO;
import Attaques.ComboGriffes;
import Attaques.Hydrocanon;
import Type.Eau;
import Type.Type;

import java.util.Arrays;

public class Psykokwak extends Pokemon{
    public Psykokwak() {
        super("Psykokwak", Eau.class, 1, 50, 52, 48, 55, "psykokwak.png", "psykokwak_f.png", "psykokwak_b.png",55,63.5,63.8,23, Arrays.asList(new ComboGriffes(), new AquaJet(), new BulledO(), new Hydrocanon()));
    }
}
