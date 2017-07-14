package com.comp3617.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.PokemonFactory;
import com.comp3617.finalproject.model.RealmManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
                    HttpUtil httpUtil = new HttpUtil();
                    httpUtil.execute("https://pokeapi.co/api/v1/pokedex/1/");
                } else {
                    addPokemon(pokemonName);
                }
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

    private void addPokemon(String pokemonName) {
        Pokemon pokemon = PokemonFactory.build(pokemonName);
        RealmManager.addPokemon(pokemon);
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public class HttpUtil extends AsyncTask<String, Void, String> {

        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... params) {
            Request.Builder builder = new Request.Builder();
            builder.url(params[0]);
            Request request = builder.build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            JSONObject json = null;
            try {
                json = new JSONObject(s);
                JSONArray pokemonArray = json.getJSONArray("pokemon");
                int size = pokemonArray.length();
                JSONObject pokemon = pokemonArray.getJSONObject(Math.abs(new Random().nextInt(size)));
                String pokemonName = pokemon.getString("name");
                addPokemon(pokemonName);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
