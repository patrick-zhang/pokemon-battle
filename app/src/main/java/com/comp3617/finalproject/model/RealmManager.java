package com.comp3617.finalproject.model;

/**
 * Created by Patrick on 7/4/2017.
 */

import java.util.ArrayList;

import io.realm.Realm;
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
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Pokemon> pokemons =
                realm.where(Pokemon.class).findAll();
        ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
        for (Pokemon pokemon : pokemons) {
            pokemonList.add(pokemon);
        }
        return pokemonList;
    }

    private static void execute(Runnable operations) {
        realm.beginTransaction();
        operations.run();
        realm.commitTransaction();
    }
}
