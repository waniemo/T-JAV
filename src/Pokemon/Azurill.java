package Pokemon;
import Attaques.*;
import Type.Fee;
import Type.Type;

import java.util.Arrays;

public class Azurill extends Pokemon{
    public Azurill() {
        super("Azurill", Fee.class, 1, 50, 20, 40, 20, "azurill.png", "azurill_f.gif", "azurill_b.gif", Arrays.asList(new ComboGriffes(), new Calinerie(), new VentFeerique(), new EclatMagique()));
    }
}
