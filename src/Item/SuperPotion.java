package Item;

import Pokemon.Pokemon;

public class SuperPotion extends Item{
    public SuperPotion() {
        super("Super potion", "Soin", "Cette potion permet de soigner un pokemon de 50PV.", "super_potion.png");
    }

    @Override
    public String use(Pokemon pokemon) {
        if(pokemon.getPv() + 50 > pokemon.getPvMax()){
            pokemon.setPv(pokemon.getPvMax());
            return pokemon.getName()+" a été soigné.";
        } else{
            pokemon.setPv(pokemon.getPv() + 50);
            return pokemon.getName() + " a été soigné de 50PV.";
        }
    }
}
