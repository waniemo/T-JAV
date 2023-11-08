public class BoostAtk extends Item{
    public BoostAtk(String name, String Type, String description) {
        super("Boost Atk", "Boost", "Cet objet augmente l'attaque de 10 points.");
    }

    @Override
    public void use(Pokemon pokemon) {
        pokemon.setAtk(pokemon.getAtk() + 10);
        System.out.println("L'attaque de " + pokemon.getName() + " a augmenté de 10 points.");
    }
}
