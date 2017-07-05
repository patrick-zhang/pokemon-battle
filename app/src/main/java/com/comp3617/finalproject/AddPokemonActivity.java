package com.comp3617.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.RealmManager;

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
                Pokemon pokemon = new Pokemon();
                pokemon.setName(nameEditText.getText().toString());
                RealmManager.addPokemon(pokemon);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            }
            default: break;
        }
    }
}
