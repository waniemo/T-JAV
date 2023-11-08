public class SuperPotion extends Item{
    public SuperPotion(String name, String Type, String description) {
        super("Super potion", "Soin", "Cette potion permet de soigner un pokemon de 50Pv");
    }

    @Override
    public void use(Pokemon pokemon) {
        pokemon.setPv(pokemon.getPv() + 50);
        System.out.println(pokemon.getName() + " a été soigné de 50Pv");
    }
}
