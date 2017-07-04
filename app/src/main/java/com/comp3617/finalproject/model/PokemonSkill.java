package com.comp3617.finalproject.model;

import io.realm.RealmObject;

/**
 * Created by Patrick on 6/11/2017.
 */

public class PokemonSkill extends RealmObject {
    private String id;
    private String name;
    private int damage;
    private String imageName;

    public PokemonSkill() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
