package Item;

import Pokemon.Pokemon;

public class HyperPotion extends Item{
    public HyperPotion() {
        super("Hyper Item.Potion", "Soin", "Cette potion permet de soigner un pokemon de 120PV");
    }

    @Override
    public void use(Pokemon pokemon) {
        pokemon.setPv(pokemon.getPv() + 120);
        System.out.println(pokemon.getName() + " a été soigné de 120PV");
    }
}
