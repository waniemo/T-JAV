package Pokemon;
import Attaques.Calinerie;
import Attaques.ComboGriffes;
import Attaques.EclatMagique;
import Attaques.VentFeerique;
import Type.Fee;
import Type.Type;

import java.util.Arrays;

public class Kirby extends Pokemon{
    public Kirby() {
        super("Kirby", Fee.class, 1, 555, 555, 100, 100, "kirby.png", "kirby_f.gif", "kirby_b.gif", Arrays.asList(new ComboGriffes(), new Calinerie(), new VentFeerique(), new EclatMagique()));
    }

}
