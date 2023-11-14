package Item;

import Pokemon.Pokemon;

public class BoostDef extends Item{
    public BoostDef() {
        super("Boost Def", "Boost", "Cet objet augmente la défense de 10 points.", "boost_def.png");
    }
    @Override
    public String use(Pokemon pokemon) {
        pokemon.setDef(pokemon.getDef() + 10);
        return "La défense de " + pokemon.getName() + " a augmenté de 10 points.";
    }
}
