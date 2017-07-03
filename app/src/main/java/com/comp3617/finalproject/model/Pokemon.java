package com.comp3617.finalproject.model;


import io.realm.RealmList;
import io.realm.RealmObject;

public class Pokemon extends RealmObject {

    private String id;
    private String name;
    private int imageName;
    private int hp;
    private RealmList<PokemonSkill> skills;

    public Pokemon() {

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

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public RealmList<PokemonSkill> getSkills() {
        return skills;
    }

    public void setSkills(RealmList<PokemonSkill> skills) {
        this.skills = skills;
    }
}
