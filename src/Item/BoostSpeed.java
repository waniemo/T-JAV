package Item;

import Pokemon.Pokemon;

public class BoostSpeed extends Item{
    public BoostSpeed() {
        super("Boost Speed", "Boost", "Cet objet augmente la vitesse de 10 points.", "boost_speed.png");
    }
    @Override
    public String use(Pokemon pokemon) {
        pokemon.setSpeed(pokemon.getSpeed() + 10);
        return "La vitesse de " + pokemon.getName() + " a augmenté de 10 points.";
    }
}
