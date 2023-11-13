package Pokemon;
import Attaques.*;
import Type.Fee;
import Type.Type;

import java.util.Arrays;

public class Gardevoir extends Pokemon{
    public Gardevoir() {
        super("Gardevoir", Fee.class, 1, 68, 65, 65, 80, "gardevoir.png", "gardevoir_f.gif", "gardevoir_b.gif", Arrays.asList(new ComboGriffes(), new Calinerie(), new VentFeerique(), new EclatMagique()));
    }

}
