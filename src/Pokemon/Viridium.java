package Pokemon;
import Attaques.ComboGriffes;
import Attaques.Phytomixeur;
import Attaques.TempeteVerte;
import Attaques.Tranchherbe;
import Type.Plante;
import Type.Type;

import java.util.Arrays;

public class Viridium extends Pokemon{
    public Viridium() {
        super("Viridium", Plante.class, 1, 91, 90, 72, 108, "viridium.png", "viridium_f.png", "viridium_b.png", 82, 94, 94, 36, Arrays.asList(new ComboGriffes(), new Tranchherbe(), new TempeteVerte(), new Phytomixeur()));
    }
}
