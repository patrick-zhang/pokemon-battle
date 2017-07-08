package com.comp3617.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.RealmManager;

import java.util.ArrayList;

public class PokemonDetailActivity extends AppCompatActivity {
    private Pokemon pokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String pokemonId = getIntent().getStringExtra("POKEMON_ID");
        pokemon = RealmManager.getPokemon(pokemonId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView nameField = (TextView) findViewById(R.id.nameTextInDetail);
        nameField.setText(pokemon.getName());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnReturnInDetail) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
