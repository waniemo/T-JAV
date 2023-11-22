package Pokemon;
import Attaques.*;
import Type.Fee;
import Type.Type;

import java.util.Arrays;

public class Doudouvet extends Pokemon{
    public Doudouvet() {
        super("Doudouvet", Fee.class, 1, 40, 27, 60, 66, "doudouvet.png", "doudouvet_f.png", "doudouvet_b.png",38,58.3,51.3,10, Arrays.asList(new ComboGriffes(), new Calinerie(), new VentFeerique(), new EclatMagique()));
    }

}
