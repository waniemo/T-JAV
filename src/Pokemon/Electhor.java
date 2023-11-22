package Pokemon;
import Attaques.CageEclair;
import Attaques.ComboGriffes;
import Attaques.Eclair;
import Attaques.FatalFoudre;
import Type.Electrik;
import Type.Type;

import java.util.Arrays;

public class Electhor extends Pokemon{
    public Electhor() {
        super("Electhor", Electrik.class, 1, 90, 90, 90, 100, "electhor.png", "electhor_f.png", "electhor_b.png",84,108 ,99,8, Arrays.asList(new ComboGriffes(), new Eclair(), new CageEclair(), new FatalFoudre()));
    }

}
