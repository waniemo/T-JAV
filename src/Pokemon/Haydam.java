package Pokemon;
import Attaques.ComboGriffes;
import Attaques.Phytomixeur;
import Attaques.TempeteVerte;
import Attaques.Tranchherbe;
import Type.Plante;
import Type.Type;

import java.util.Arrays;

public class Haydam extends Pokemon{
    public Haydam() {
        super("Haydam", Plante.class, 1, 60, 70, 65, 125, "haydam.png", "haydam_f.gif", "haydam_b.gif", Arrays.asList(new ComboGriffes(), new Tranchherbe(), new TempeteVerte(), new Phytomixeur()));
    }

}
