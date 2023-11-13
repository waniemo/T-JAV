package Item;

import Pokemon.Pokemon;

public class BoostAtk extends Item{
    public BoostAtk(){
        super("Boost Atk", "Boost", "Cet objet augmente l'attaque de 10 points.", "boost_atk.png");
    }

    @Override
    public void use(Pokemon pokemon) {
        pokemon.setAtk(pokemon.getAtk() + 10);
        System.out.println("L'attaque de " + pokemon.getName() + " a augmenté de 10 points.");
    }
}
