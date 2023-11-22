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
        super("Togepi", Fee.class, 1, 35, 20, 65, 40, "togepi.png", "togepi_f.png", "togepi_b.png", 52, 58, 58, 36, Arrays.asList(new ComboGriffes(), new Calinerie(), new VentFeerique(), new EclatMagique()));
    }
}
