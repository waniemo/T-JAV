package Pokemon;
import Attaques.ComboGriffes;
import Attaques.FeuDenfer;
import Attaques.RafaleFeu;
import Attaques.TacleFeu;
import Type.Feu;
import Type.Type;

import java.util.Arrays;

public class Simiabraz extends Pokemon{
    public Simiabraz() {
        super("Simiabraz", Feu.class , 1, 76, 104, 71, 108, "simiabraz.png", "simiabraz_f.gif", "simiabraz_b.gif", Arrays.asList(new ComboGriffes(), new TacleFeu(), new RafaleFeu(), new FeuDenfer()));
    }
}
