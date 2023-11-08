public class HyperPotion extends Item{
    public HyperPotion(String name, String Type, String description) {
        super(name, Type, description);
    }

    @Override
    public void use(Pokemon pokemon) {
        pokemon.setPv(pokemon.getPv() + 120);
        System.out.println(pokemon.getName() + " a été soigné de 120HP");
    }
}
