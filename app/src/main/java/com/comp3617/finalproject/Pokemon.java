package com.comp3617.finalproject;

import java.util.List;

/**
 * Created by Patrick on 6/11/2017.
 */

public class Pokemon {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int photo;

    private int icon;

    private int hp;

    private List<PokemonSkill> skills;

    public Pokemon () {

    }
}
