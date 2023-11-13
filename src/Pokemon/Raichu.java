package Pokemon;

import Attaques.CageEclair;
import Attaques.ComboGriffes;
import Attaques.Eclair;
import Attaques.FatalFoudre;
import Type.Electrik;
import Type.Type;

import java.util.Arrays;

public class Raichu extends Pokemon{
    public Raichu() {
        super("Raichu", Electrik.class, 1, 60, 90, 55, 110, "raichu.png", "raichu_f.gif", "raichu_b.gif", Arrays.asList(new ComboGriffes(), new Eclair(), new CageEclair(), new FatalFoudre()));
    }
}
