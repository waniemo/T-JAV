package Item;

import Pokemon.Pokemon;

public class Rappel extends Item{
    public Rappel() {
        super("Rappel", "Soin", "Cet objet réanimer un pokemon KO avec 10PV", "rappel.png");
    }

    @Override
    public void use(Pokemon pokemon) {
        if(pokemon.getPv() > 0){
            System.out.println("Ce pokemon n'est pas KO !");
        } else{
            pokemon.setPv(10);
            System.out.println(pokemon.getName() + " a été réanimé et à recupéré 10PV");
        }

    }
}
