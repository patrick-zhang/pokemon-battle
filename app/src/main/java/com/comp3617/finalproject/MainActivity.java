package com.comp3617.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.PokemonFactory;
import com.comp3617.finalproject.model.RealmManager;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.pokemonList);
        List<Pokemon> pokemonList = RealmManager.getPokemonList();
        PokemonListAdapter adapter = new PokemonListAdapter(this, pokemonList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(MainActivity.this, PokemonDetailActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void performAction(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addItem: {
                Intent intent = new Intent(this, AddPokemonActivity.class);
                startActivity(intent);
                finish();
            }
            default : {
              break;
            }
        }
    }
}
