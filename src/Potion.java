public class Potion extends Item{
    public Potion(String name, String Type, String description) {
        super("Potion", "Soin", "Cette potion permet de soigner un pokemon de 20HP");
    }

    @Override
    public void use(Pokemon pokemon) {
        pokemon.setPv(pokemon.getPv() + 20);
        System.out.println(pokemon.getName() + " a été soigné de 20HP");
    }
}
