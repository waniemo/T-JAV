package Pokemon;
import Attaques.ComboGriffes;
import Attaques.Phytomixeur;
import Attaques.TempeteVerte;
import Attaques.Tranchherbe;
import Type.Plante;
import Type.Type;

import java.util.Arrays;

public class Bulbizarre extends Pokemon{
    public Bulbizarre() {
        super("Bulbizarre", Plante.class, 1, 45, 49, 49, 45, "bulbizarre.png", "bulbizarre_f.gif", "bulbizarre_b.gif", Arrays.asList(new ComboGriffes(), new Tranchherbe(), new TempeteVerte(), new Phytomixeur()));
    }

}
