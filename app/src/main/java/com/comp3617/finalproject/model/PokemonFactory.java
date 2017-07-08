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

    private static int getHp() {
        int range = new Random().nextInt(Config.BASE_HP_RANGE);
        return Config.BASE_HP + range;
    }
}
