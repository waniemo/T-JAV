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
        super("Roserade", Plante.class, 1, 60, 70, 65, 125, "roserade.png", "roserade_f.png", "roserade_b.png", 75, 88, 88, 16, Arrays.asList(new ComboGriffes(), new Tranchherbe(), new TempeteVerte(), new Phytomixeur()));
    }
}
