package Pokemon;
import Attaques.ComboGriffes;
import Attaques.FeuDenfer;
import Attaques.RafaleFeu;
import Attaques.TacleFeu;
import Type.Feu;
import Type.Type;

import java.util.Arrays;

public class Reshiram extends Pokemon{
    public Reshiram() {
        super("Reshiram", Feu.class, 1, 100, 120, 100, 90, "reshiram.png", "reshiram_f.png", "reshiram_b.png",96,133.3,133.3,15, Arrays.asList(new ComboGriffes(), new TacleFeu(), new RafaleFeu(), new FeuDenfer()));
    }
}
