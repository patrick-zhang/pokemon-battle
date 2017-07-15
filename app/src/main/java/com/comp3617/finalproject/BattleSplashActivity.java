package com.comp3617.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.RealmManager;
import com.comp3617.finalproject.utils.IntentUtil;

public class BattleSplashActivity extends AppCompatActivity {
   private Pokemon pokemon;
    private static int trainCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_splash);
        String pokemonId = getIntent().getStringExtra(IntentUtil.POKE_ID_INTENT);
        pokemon = RealmManager.getPokemon(pokemonId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView nameField = (TextView) findViewById(R.id.tvPokemonName);
        nameField.setText(pokemon.getName());
        String imageName = pokemon.getImageName();
        if (imageName != null && !imageName.isEmpty()) {
            ImageView imageView = (ImageView) findViewById(R.id.ivPokemonImage);
            int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            imageView.setImageResource(resID);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnReturnInBattleSplash) {
            setResult(Activity.RESULT_OK, new Intent());
            finish();
        }
        if (view.getId() == R.id.btnTrainInBattleSplash) {
            Intent trainIntent = new Intent(this, BattleActivity.class);
            trainIntent.putExtra(IntentUtil.POKE_ID_INTENT, pokemon.getId());
            startActivityForResult(trainIntent, trainCode);
        }
    }
}
