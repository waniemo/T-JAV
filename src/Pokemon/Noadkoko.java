package Pokemon;
import Attaques.ComboGriffes;
import Attaques.Phytomixeur;
import Attaques.TempeteVerte;
import Attaques.Tranchherbe;
import Type.Plante;
import Type.Type;

import java.util.Arrays;

public class Noadkoko extends Pokemon{
    public Noadkoko() {
        super("Noadkoko", Plante.class, 1, 60, 55, 90, 80, "noadkoko.png", "noadkoko_f.png", "noadkoko_b.png",84,77.5,79.4,7, Arrays.asList(new ComboGriffes(), new Tranchherbe(), new TempeteVerte(), new Phytomixeur()));
    }
}
