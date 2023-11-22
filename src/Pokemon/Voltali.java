package Pokemon;

import Attaques.CageEclair;
import Attaques.ComboGriffes;
import Attaques.Eclair;
import Attaques.FatalFoudre;
import Type.Electrik;
import Type.Type;

import java.util.Arrays;

public class Voltali extends Pokemon{
    public Voltali() {
        super("Voltali", Electrik.class, 1, 65, 65, 60, 130, "voltali.png", "voltali_f.png", "voltali_b.png", 60, 53, 54, 9, Arrays.asList(new ComboGriffes(), new Eclair(), new CageEclair(), new FatalFoudre()));
    }

}
