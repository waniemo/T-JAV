public class BoostSpeed extends Item{
    public BoostSpeed(String name, String Type, String description) {
        super("Boost Speed", "Boost", "Cet objet augmente la vitesse de 10 points.");
    }
    @Override
    public void use(Pokemon pokemon) {
        pokemon.setSpeed(pokemon.getSpeed() + 10);
        System.out.println("La vitesse de " + pokemon.getName() + " a augmenté de 10 points.");
    }
}
