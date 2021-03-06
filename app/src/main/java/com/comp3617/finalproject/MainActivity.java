package com.comp3617.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.RealmManager;
import com.comp3617.finalproject.utils.IntentUtil;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private static int addRequestCode = 1;
    private static int settingsRequestCode = 2;
    private static int detailRequestCode = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listView = (ListView) findViewById(R.id.pokemonList);
        final List<Pokemon> pokemonList = RealmManager.getPokemonList();
        PokemonListAdapter adapter = new PokemonListAdapter(this, pokemonList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(MainActivity.this, PokemonDetailActivity.class);
                intent.putExtra(IntentUtil.POKE_ID_INTENT, pokemonList.get(position).getId());
                startActivityForResult(intent, detailRequestCode);
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
                startActivityForResult(intent, addRequestCode);
                break;
            }
            case R.id.settings: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivityForResult(intent, settingsRequestCode);
                break;
            }
            default : {
              break;
            }
        }
    }
}
