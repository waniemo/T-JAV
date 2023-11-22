package Pokemon;
import Attaques.ComboGriffes;
import Attaques.FeuDenfer;
import Attaques.RafaleFeu;
import Attaques.TacleFeu;
import Type.Feu;
import Type.Type;

import java.util.Arrays;

public class HoOh extends Pokemon{
    public HoOh() {
        super("Ho-Oh", Feu.class , 1, 130, 90, 110, 154, "hooh.png", "hooh_f.png", "hooh_b.png", 110, 110, 112, 13, Arrays.asList(new ComboGriffes(), new TacleFeu(), new RafaleFeu(), new FeuDenfer()));
    }

}
