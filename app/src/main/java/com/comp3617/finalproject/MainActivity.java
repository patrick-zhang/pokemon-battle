package com.comp3617.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.pokemonList);
        List<Pokemon> pokemonList = new ArrayList<Pokemon>();
        pokemonList.add(new Pokemon());
        pokemonList.add(new Pokemon());
        pokemonList.add(new Pokemon());
        PokemonListAdapter adapter = new PokemonListAdapter(this, pokemonList);
        listView.setAdapter(adapter);
    }
}
