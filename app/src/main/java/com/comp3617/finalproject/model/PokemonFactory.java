package com.comp3617.finalproject.model;

import com.comp3617.finalproject.config.Config;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Patrick on 6/12/2017.
 */

public class PokemonFactory {
    public static Pokemon build(String name) {
        String imageName = "shadow_image";
        return build(name, imageName, null);
    }

    public static Pokemon build(String name, String imageName, String id) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setHp(getHp());
        pokemon.setImageName(imageName);
        if (id != null) {
            pokemon.setId(id);
        }
        pokemon.setSkills(RealmManager.getSkillSet());
        return pokemon;
    }

    private static int getHp() {
        int range = new Random().nextInt(Config.BASE_HP_RANGE);
        return Config.BASE_HP + range;
    }

    public static ArrayList<Pokemon> getInitialPokemonList(){
        ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
        pokemonList.add(build("Pichachu", "pichachu_image", "001"));
        pokemonList.add(build("Giant Bomb", "giant_bomb_image", "002"));
        pokemonList.add(build("Fennekin", "fennekin_image", "003"));
        pokemonList.add(build("Quilava", "quilava_image", "004"));
        pokemonList.add(build("Salamence", "salamence_image", "005"));
        pokemonList.add(build("Hydreigon", "hydreigon_image", "006"));
        pokemonList.add(build("Gliscor", "gliscor_image", "007"));
        return pokemonList;
    }

    public static Pokemon getEnemy(){
        return build("Croagunk", "croagunk_image", "000");
    }

}
