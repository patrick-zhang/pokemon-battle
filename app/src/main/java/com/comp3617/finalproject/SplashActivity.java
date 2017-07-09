package com.comp3617.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.comp3617.finalproject.model.PokemonFactory;
import com.comp3617.finalproject.model.RealmManager;
import com.comp3617.finalproject.model.SkillFactory;
import com.comp3617.finalproject.utils.PrefUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        PrefUtil prefUtil = new PrefUtil(this);
        boolean initialized = prefUtil.getBoolean(PrefUtil.PREF_KEY_INITIALIZED, false);
        if (!initialized) {
            RealmManager.addSkill(SkillFactory.getSkillList());
            RealmManager.addPokemon(PokemonFactory.getInitialPokemonList());
            prefUtil.setBoolean(PrefUtil.PREF_KEY_INITIALIZED, true);
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
