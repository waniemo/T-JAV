package Pokemon;
import Attaques.*;
import Type.Fee;
import Type.Type;

import java.util.Arrays;

public class Gardevoir extends Pokemon{
    public Gardevoir() {
        super("Gardevoir", Fee.class, 1, 68, 65, 65, 80, "gardevoir.png", "gardevoir_f.png", "gardevoir_b.png",92,95,92,8, Arrays.asList(new ComboGriffes(), new Calinerie(), new VentFeerique(), new EclatMagique()));
    }

}
