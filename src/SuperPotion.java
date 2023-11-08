public class SuperPotion extends Item{
    public SuperPotion() {
        super("Super potion", "Soin", "Cette potion permet de soigner un pokemon de 50PV");
    }

    @Override
    public void use(Pokemon pokemon) {
        pokemon.setPv(pokemon.getPv() + 50);
        System.out.println(pokemon.getName() + " a été soigné de 50PV");
    }
}
