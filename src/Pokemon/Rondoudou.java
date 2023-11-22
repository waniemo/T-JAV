package Pokemon;
import Attaques.Calinerie;
import Attaques.ComboGriffes;
import Attaques.EclatMagique;
import Attaques.VentFeerique;
import Type.Fee;

import java.util.Arrays;

public class Rondoudou extends Pokemon{
    public Rondoudou() {
        super("Rondoudou", Fee.class, 1, 115, 45, 20, 20, "rondoudou.png", "rondoudou_f.png", "rondoudou_b.png", 45, 56.5, 151.5, 19,  Arrays.asList(new ComboGriffes(), new Calinerie(), new VentFeerique(), new EclatMagique()));
    }

}
