package Pokemon;

import Attaques.ComboGriffes;
import Attaques.FeuDenfer;
import Attaques.RafaleFeu;
import Attaques.TacleFeu;
import Type.Feu;
import Type.Type;

import java.util.Arrays;

public class Hericendre extends Pokemon {

    public Hericendre() {
        super("Héricendre", Feu.class, 1, 39, 52, 43, 65, "hericendre.png", "hericendre_f.png", "hericendre_b.png",37, 47.5,47.5,12, Arrays.asList(new ComboGriffes(), new TacleFeu(), new RafaleFeu(), new FeuDenfer()));
    }

}
