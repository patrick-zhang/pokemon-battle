package com.comp3617.finalproject.model;

import android.net.Uri;
import android.util.Log;

import com.comp3617.finalproject.R;
import com.comp3617.finalproject.config.Config;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Patrick on 6/12/2017.
 */

public class PokemonFactory {
    public static Pokemon build(String name, String imageName) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setHp(getHp());
        pokemon.setImageName(imageName);
        pokemon.setSkills(RealmManager.getSkillSet());
        return pokemon;
    }

    private static int getHp() {
        int range = new Random().nextInt(Config.BASE_HP_RANGE);
        return Config.BASE_HP + range;
    }

    public static Pokemon getEnemy(){
        return build("Croagunk", "croagunk_image");
    }

}
