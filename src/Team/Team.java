package Team;

import Item.*;
import Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Team {
    private List<Pokemon> team;
    private ArrayList<Pokemon> deadPokemons = new ArrayList<>();
    private Pokemon activePokemon;
    private HashMap<Class<? extends Item>, Integer> items = new HashMap<>();

    public Team(List<Pokemon> team){
        this.team = team;
        this.activePokemon = team.get(0);
        items.put(BoostAtk.class, 5);
        items.put(BoostDef.class, 5);
        items.put(BoostSpeed.class, 5);
        items.put(Potion.class, 5);
        items.put(SuperPotion.class, 5);
        items.put(HyperPotion.class, 5);
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

    public HashMap<Class<? extends Item>, Integer> getItems() {
        return items;
    }

    public void setActivePokemon(Pokemon newActivePokemon){
        Pokemon oldActivePokemon = this.activePokemon;
        if(!deadPokemons.contains(newActivePokemon)){
            this.activePokemon = newActivePokemon;
            System.out.println(oldActivePokemon.getName()+" reviens ! "+newActivePokemon.getName()+" GO !");
        } else {
            System.out.println("Vous ne pouvez pas selectioner un pokémon KO !");
        }
    }

    public void setTeamLvl(int lvl){
        for(Pokemon pokemon : team){
            pokemon.setLevel(lvl);
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
        if(items.get(itemToUse.getClass()) > 0){
            itemToUse.use(pokemon);
            items.put(itemToUse.getClass(), items.get(itemToUse.getClass()) - 1);
        } else {
            System.out.println("Vous n'avez plus de "+itemToUse.getName());
        }

    }

}
