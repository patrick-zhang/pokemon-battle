package com.comp3617.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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
    private static int RESULT_LOAD_IMAGE = 1;
    private String imageFilePath = "";

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
            case R.id.ivPokemonImage: {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
                break;
            }
            default: break;
        }
    }

    private void addPokemon(String pokemonName) {
        Pokemon pokemon = PokemonFactory.build(pokemonName, imageFilePath);
        RealmManager.addPokemon(pokemon);
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imageFilePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.ivPokemonImage);
            imageView.setImageBitmap(BitmapFactory.decodeFile(imageFilePath));
        }
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
