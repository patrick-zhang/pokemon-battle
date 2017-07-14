package com.comp3617.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.PokemonFactory;
import com.comp3617.finalproject.model.RealmManager;
import com.comp3617.finalproject.utils.HttpUtil;

public class AddPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokemon);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddPokemon: {
                EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
                String pokemonName = nameEditText.getText().toString();
                if (pokemonName.isEmpty()) {
                    pokemonName = HttpUtil.getPokemonName();
                }
                Pokemon pokemon = PokemonFactory.build(pokemonName);
                RealmManager.addPokemon(pokemon);
                Intent intent = new Intent();
                setResult(Activity.RESULT_OK, intent);
                finish();
                break;
            }
            case R.id.btnBackInAdd: {
                Intent intent = new Intent();
                setResult(Activity.RESULT_CANCELED, intent);
                finish();
                break;
            }
            default: break;
        }
    }
}
