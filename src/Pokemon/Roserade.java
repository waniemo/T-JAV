package Pokemon;
import Attaques.ComboGriffes;
import Attaques.Phytomixeur;
import Attaques.TempeteVerte;
import Attaques.Tranchherbe;
import Type.Plante;
import Type.Type;

import java.util.Arrays;

public class Roserade extends Pokemon{
    public Roserade() {
        super("Roserade", Plante.class, 1, 60, 70, 65, 125, "roserade.png", "roserade_f.gif", "roserade_b.gif", Arrays.asList(new ComboGriffes(), new Tranchherbe(), new TempeteVerte(), new Phytomixeur()));
    }
}
