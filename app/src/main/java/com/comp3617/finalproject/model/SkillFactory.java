package com.comp3617.finalproject.model;

import com.comp3617.finalproject.config.Config;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Patrick on 7/8/2017.
 */

public class SkillFactory {
    public static ArrayList<PokemonSkill> getSkillList () {
        ArrayList<PokemonSkill> skillList = new ArrayList<PokemonSkill>();
        skillList.add(build("Claw", "default_skill_image"));
        return skillList;
    }

    private static PokemonSkill build(String name, String imageName) {
        PokemonSkill skill = new PokemonSkill();
        skill.setName(name);
        skill.setImageName(imageName);
        skill.setDamage(getDamage());
        return skill;
    }

    private static int getDamage () {
        int range = new Random().nextInt(Config.BASE_DAMAGE_RANGE);
        return Config.BASE_DAMAGE + range;
    }
}
