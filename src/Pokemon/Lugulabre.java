package Pokemon;
import Attaques.ComboGriffes;
import Attaques.FeuDenfer;
import Attaques.RafaleFeu;
import Attaques.TacleFeu;
import Type.Feu;
import Type.Type;

import java.util.Arrays;

public class Lugulabre extends Pokemon{
    public Lugulabre() {
        super("Lugulabre", Feu.class, 1, 60, 55, 90, 80, "lugulabre.png", "lugulabre_f.png", "lugulabre_b.png",81,100,100, 8, Arrays.asList(new ComboGriffes(), new TacleFeu(), new RafaleFeu(), new FeuDenfer()));
    }

}
