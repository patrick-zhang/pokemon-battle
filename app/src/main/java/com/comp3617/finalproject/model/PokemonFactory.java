package com.comp3617.finalproject.model;

import com.comp3617.finalproject.model.Pokemon;

import java.util.ArrayList;

/**
 * Created by Patrick on 6/12/2017.
 */

public class PokemonFactory {
    public PokemonFactory () {

    }
    public static ArrayList<Pokemon> create(){
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        Pokemon p1 = new Pokemon();
        p1.setName("Pikachu");
        pokemons.add(p1);
        return pokemons;
    }
}
