public class BoostDef extends Item{
    public BoostDef(String name, String Type, String description) {
        super("Boost Def", "Boost", "Cet objet augmente la défense de 10 points.");
    }
    @Override
    public void use(Pokemon pokemon) {
        pokemon.setDef(pokemon.getDef() + 10);
        System.out.println("La défense de " + pokemon.getName() + " a augmenté de 10 points.");
    }
}
