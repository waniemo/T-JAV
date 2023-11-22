package Pokemon;
import Attaques.ComboGriffes;
import Attaques.FeuDenfer;
import Attaques.RafaleFeu;
import Attaques.TacleFeu;
import Type.Feu;
import Type.Type;

import java.util.Arrays;

public class Ponyta extends Pokemon{
    public Ponyta() {
        super("Ponyta", Feu.class, 1, 50, 85, 55, 90, "ponyta.png", "ponyta_f.png", "ponyta_b.png", 60, 59.5, 59.5 , 10,  Arrays.asList(new ComboGriffes(), new TacleFeu(), new RafaleFeu(), new FeuDenfer()));
    }

}
