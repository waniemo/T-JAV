package Pokemon;
import Attaques.CageEclair;
import Attaques.ComboGriffes;
import Attaques.Eclair;
import Attaques.FatalFoudre;
import Type.Electrik;
import Type.Type;

import java.util.Arrays;

public class Zekrom extends Pokemon{
    public Zekrom() {
        super("Zekrom", Electrik.class, 1, 100, 150, 120, 90, "zekrom.png", "zekrom_f.png", "zekrom_b.png", 106, 133.9, 133.9, 9, Arrays.asList(new ComboGriffes(), new Eclair(), new CageEclair(), new FatalFoudre()));
    }
}
