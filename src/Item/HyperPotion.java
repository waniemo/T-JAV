package Item;

import Pokemon.Pokemon;

public class HyperPotion extends Item{
    public HyperPotion() {
        super("Hyper Potion", "Soin", "Cette potion permet de soigner un pokemon de 120PV.", "hyper_potion.png");
    }

    @Override
    public String use(Pokemon pokemon) {
        if(pokemon.getPv()+120 > pokemon.getPvMax()){
            pokemon.setPv(pokemon.getPvMax());
            return pokemon.getName()+" a été soigné au maximum de ses PV.";
        } else{
            pokemon.setPv(pokemon.getPv() + 120);
            return pokemon.getName() + " a été soigné de 120PV.";
        }
    }
}
