package Pokemon;

import Attaques.CageEclair;
import Attaques.ComboGriffes;
import Attaques.Eclair;
import Attaques.FatalFoudre;
import Type.Electrik;
import Type.Type;

import java.util.Arrays;

public class Voltorbe extends Pokemon{
    public Voltorbe() {
        super("Voltorbe", Electrik.class, 1, 40, 30, 50, 100, "voltorbe.png", "voltorbe_f.gif", "voltorbe_b.gif", Arrays.asList(new ComboGriffes(), new Eclair(), new CageEclair(), new FatalFoudre()));
    }
}
