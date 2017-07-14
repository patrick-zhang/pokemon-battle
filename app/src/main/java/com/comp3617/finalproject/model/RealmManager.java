package com.comp3617.finalproject.model;

/**
 * Created by Patrick on 7/4/2017.
 */

import com.comp3617.finalproject.config.Config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class RealmManager {

    private static Realm realm = Realm.getDefaultInstance();

    public static void addPokemon(final Pokemon p) {
        execute(new Runnable() {
            @Override
            public void run() {
                Pokemon pokemon = realm.copyToRealm(p);
            }
        });
    }

    public static void deletePokemon(final String pokemonId) {
        execute(new Runnable() {
            @Override
            public void run() {
                Pokemon pokemon = getPokemon(pokemonId);
                pokemon.removeFromRealm();
            }
        });
    }

    public static void deletePokemon() {
        execute(new Runnable() {
            @Override
            public void run() {
                realm.where(Pokemon.class).findAll().clear();
            }
        });
    }


    public static Pokemon getPokemon(String pokemonId) {
        return realm.where(Pokemon.class)
                .equalTo("id", pokemonId)
                .findFirst();
    }

    public static ArrayList<Pokemon> getPokemonList() {
        RealmResults<Pokemon> pokemons =
                realm.where(Pokemon.class).findAll();
        ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
        for (Pokemon pokemon : pokemons) {
            pokemonList.add(pokemon);
        }
        return pokemonList;
    }

    public static void addPokemon(ArrayList<Pokemon> pokemons) {
        for (Pokemon pokemon : pokemons) {
            addPokemon(pokemon);
        }
    }
    public static void addPokemonSkill(final PokemonSkill s) {
        execute(new Runnable() {
            @Override
            public void run() {
                PokemonSkill skill = realm.copyToRealm(s);
            }
        });
    }

    public static void addSkill(ArrayList<PokemonSkill> skills) {
        for (PokemonSkill skill : skills) {
            addPokemonSkill(skill);
        }
    }

    public static RealmList<PokemonSkill> getSkillList() {
        RealmResults<PokemonSkill> pokemonskills =
                realm.where(PokemonSkill.class).findAll();
        RealmList<PokemonSkill> skillsList = new RealmList<PokemonSkill>();
        skillsList.addAll(pokemonskills.subList(0, pokemonskills.size()));
        return skillsList;
    }

    public static RealmList<PokemonSkill> getSkillSet() {
        RealmResults<PokemonSkill> skillRealmResults =
                realm.where(PokemonSkill.class).findAll();
        Set<PokemonSkill> skillSet = new HashSet<PokemonSkill>();
        Random rand = new Random();
        for (int i = 0; i < Config.MAX_SKILL_NUMBER; i++) {
            skillSet.add(skillRealmResults.get(rand.nextInt(skillRealmResults.size())));
        }
        RealmList<PokemonSkill> skillsList = new RealmList<PokemonSkill>();
        for (PokemonSkill skill : skillSet) {
            skillsList.add(skill);
        }
        return skillsList;
    }

    public static void deletePokemonSkill() {
        execute(new Runnable() {
            @Override
            public void run() {
                realm.where(PokemonSkill.class).findAll().clear();
            }
        });
    }

    private static void execute(Runnable operations) {
        realm.beginTransaction();
        operations.run();
        realm.commitTransaction();
    }
}
