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
        super("Reshiram", Feu.class, 1, 100, 120, 100, 90, "reshiram.png", "reshiram_f.gif", "reshiram_b.gif",96,118,118,15, Arrays.asList(new ComboGriffes(), new TacleFeu(), new RafaleFeu(), new FeuDenfer()));
    }
}
