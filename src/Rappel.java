public class Rappel extends Item{
    public Rappel() {
        super("Rappel", "Soin", "Cet objet réanimer un pokemon KO avec 10PV");
    }

    @Override
    public void use(Pokemon pokemon) {
        pokemon.setPv(10);
        System.out.println(pokemon.getName() + " a été réanimé et à recupéré 10PV");
    }
}
