package Item;

import Pokemon.Pokemon;

public class Potion extends Item{
    public Potion() {
        super("Item.Potion", "Soin", "Cette potion permet de soigner un pokemon de 20PV");
    }

    @Override
    public void use(Pokemon pokemon) {
        pokemon.setPv(pokemon.getPv() + 20);
        System.out.println(pokemon.getName() + " a été soigné de 20PV");
    }
}
