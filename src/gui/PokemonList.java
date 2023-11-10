package gui;

import java.util.Arrays;

import Pokemon.*;

public class PokemonList {
    private static Pokemon[] pokemons = {
            new Hericendre(), new Ponyta(), new Reshiram(), new Lugulabre(), new HoOh(), new Simiabraz(),
            new Voltorbe(), new Zekrom(), new Raichu(), new Voltali(), new Pachirisu(), new Electhor(),
            new Blizzaroi(), new Bulbizarre(), new Noadkoko(), new Viridium(), new Roserade(), new Haydam(),
            new Musteflott(), new Dialga(), new Tiplouf(), new Magicarpe(), new Psykokwak(), new Moustillon(),
            new Rondoudou(), new Doudouvet(), new Gardevoir(), new Azurill(), new Togepi()
    };

    public static Pokemon[] getPokemons() {
        return pokemons;
    }

    public static Pokemon[] getPokemonsWithKirby() {
        pokemons = Arrays.copyOf(pokemons, pokemons.length + 1);
        pokemons[pokemons.length - 1] = new Kirby();
        return pokemons;
    }
}
