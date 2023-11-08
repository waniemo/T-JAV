import java.util.HashMap;
import java.util.List;

public class Team {
    private List<Pokemon> team;
    private List<Pokemon> deadPokemons;
    private Pokemon activePokemon;
    private HashMap<Item, Integer> items = new HashMap<>();

    public Team(List<Pokemon> team){
        this.team = team;
        this.activePokemon = team.get(0);
        items.put(new BoostAtk(), 5);
        items.put(new BoostDef(), 5);
        items.put(new BoostSpeed(), 5);
        items.put(new Potion(), 5);
        items.put(new SuperPotion(), 5);
        items.put(new HyperPotion(), 5);
    }

    public List<Pokemon> getTeam(){
        return team;
    }

    public List<Pokemon> getDeadPokemons(){
        return deadPokemons;
    }

    public Pokemon getActivePokemon(){
        return activePokemon;
    }

    public void setActivePokemon(Pokemon newActivePokemon){
        if(!deadPokemons.contains(newActivePokemon)){
            this.activePokemon = newActivePokemon;
            System.out.println(activePokemon.getName()+" reviens ! "+newActivePokemon.getName()+" GO !");
        } else {
            System.out.println("Vous ne pouvez pas selectioner un pokémon KO !");
        }
    }

    public void addPokemon(Pokemon pokemon){
        team.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon){
        team.remove(pokemon);
    }

    public void addDeadPokemon(Pokemon pokemon){
        deadPokemons.add(pokemon);
    }

    public void removeDeadPokemon(Pokemon pokemon){
        deadPokemons.remove(pokemon);
    }

    public void useItems(Item itemToUse, Pokemon pokemon){

    }


}
