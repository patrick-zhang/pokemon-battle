package com.comp3617.finalproject.model;

import com.comp3617.finalproject.config.Config;
import com.comp3617.finalproject.model.Pokemon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Patrick on 6/12/2017.
 */

public class PokemonFactory {
    public static Pokemon build(String name) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setHp(getHp());
        return pokemon;
    }

    public static Pokemon build(String name, String imageName) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setHp(getHp());
        pokemon.setImageName(imageName);
        return pokemon;
    }

    private static int getHp() {
        int range = new Random().nextInt(Config.BASE_HP_RANGE);
        return Config.BASE_HP + range;
    }

    public static ArrayList<Pokemon> getInitialPokemonList(){
        ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
        pokemonList.add(build("Pichachu", "pichachu_image"));
        pokemonList.add(build("Giant Bomb", "giant_bomb_image"));
        pokemonList.add(build("Fennekin", "fennekin_image"));
        pokemonList.add(build("Quilava", "quilava_image"));
        return pokemonList;
    }
}
