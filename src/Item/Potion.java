package Item;

import Pokemon.Pokemon;

public class Potion extends Item{
    public Potion() {
        super("Potion", "Soin", "Cette potion permet de soigner un pokemon de 20PV", "potion.png");
    }

    @Override
    public void use(Pokemon pokemon) {
        if(pokemon.getPv()+20 > pokemon.getPvMax()){
            pokemon.setPv(pokemon.getPvMax());
            System.out.println(pokemon.getClass().getName()+" a été soigné");
        } else{
            pokemon.setPv(pokemon.getPv() + 20);
            System.out.println(pokemon.getName() + " a été soigné de 20PV");
        }
    }
}
