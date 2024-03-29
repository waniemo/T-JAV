package Item;

import Pokemon.Pokemon;

public class Potion extends Item{
    public Potion() {
        super("Potion", "Soin", "Cette potion permet de soigner un pokemon de 20PV.", "potion.png");
    }

    @Override
    public String use(Pokemon pokemon) {
        if(pokemon.getPv()+20 > pokemon.getPvMax()){
            pokemon.setPv(pokemon.getPvMax());
            return pokemon.getName()+" a été soigné au maximum de ses PV.";
        } else{
            pokemon.setPv(pokemon.getPv() + 20);
            return pokemon.getName() + " a été soigné de 20PV.";
        }
    }
}
