package com.comp3617.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.PokemonFactory;
import com.comp3617.finalproject.model.RealmManager;
import com.comp3617.finalproject.utils.PrefUtil;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void onClick (View view) {
        if (view.getId() == R.id.btnDeleteAll) {
            RealmManager.deletePokemon();
            new PrefUtil(this).setBoolean(PrefUtil.PREF_KEY_INITIALIZED, false);
        }
        if (view.getId() == R.id.btnImportPokemon) {
            RealmManager.addPokemon(PokemonFactory.getInitialPokemonList());
        }
    }
}
