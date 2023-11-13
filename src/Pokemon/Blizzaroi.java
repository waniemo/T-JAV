package Pokemon;

import Attaques.ComboGriffes;
import Attaques.Phytomixeur;
import Attaques.TempeteVerte;
import Attaques.Tranchherbe;
import Type.Plante;
import Type.Type;

import java.util.Arrays;

public class Blizzaroi extends Pokemon{
    public Blizzaroi() {
        super("Blizzaroi", Plante.class, 1, 90, 92, 75, 60, "blizzaroi.png", "blizzaroi_f.gif", "blizzaroi_b.gif", Arrays.asList(new ComboGriffes(), new Tranchherbe(), new TempeteVerte(), new Phytomixeur()));
    }

}
