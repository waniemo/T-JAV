package Pokemon;
import Attaques.CageEclair;
import Attaques.ComboGriffes;
import Attaques.Eclair;
import Attaques.FatalFoudre;
import Type.Electrik;
import Type.Type;

import java.util.Arrays;

public class Pachirisu extends Pokemon{
    public Pachirisu() {
        super("Pachirisu", Electrik.class, 1, 60, 45, 70, 95, "pachirisu.png", "pachirisu_f.gif", "pachirisu_b.gif", Arrays.asList(new ComboGriffes(), new Eclair(), new CageEclair(), new FatalFoudre()));
    }
}
