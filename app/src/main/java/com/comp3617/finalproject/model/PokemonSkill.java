package com.comp3617.finalproject.model;

import io.realm.RealmObject;

/**
 * Created by Patrick on 6/11/2017.
 */

public class PokemonSkill extends RealmObject {
    private String id;
    private int name;
    private int damage;
    private int imageName;

    public PokemonSkill() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }
}
