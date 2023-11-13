package Pokemon;
import Attaques.Calinerie;
import Attaques.ComboGriffes;
import Attaques.EclatMagique;
import Attaques.VentFeerique;
import Type.Fee;
import Type.Type;

import java.util.Arrays;

public class Togepi extends Pokemon{
    public Togepi() {
        super("Togepi", Fee.class, 1, 35, 20, 65, 40, "togepi.png", "togepi_f.gif", "togepi_b.gif", Arrays.asList(new ComboGriffes(), new Calinerie(), new VentFeerique(), new EclatMagique()));
    }
}
