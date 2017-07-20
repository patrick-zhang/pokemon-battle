package com.comp3617.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.PokemonSkill;
import com.comp3617.finalproject.model.RealmManager;
import com.comp3617.finalproject.utils.IntentUtil;

import java.util.List;

public class PokemonDetailActivity extends AppCompatActivity {
    private Pokemon pokemon;
    private static int trainCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String pokemonId = getIntent().getStringExtra(IntentUtil.POKE_ID_INTENT);
        pokemon = RealmManager.getPokemon(pokemonId);
        ListView listView = (ListView) findViewById(R.id.pokemonSkillList);
        final List<PokemonSkill> pokemonSkillList = pokemon.getSkills();
        PokemonSkillListAdapter adapter = new PokemonSkillListAdapter(this, pokemonSkillList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView nameField = (TextView) findViewById(R.id.nameTextInDetail);
        nameField.setText(pokemon.getName());
        TextView hpField = (TextView) findViewById(R.id.hpTextInDetail);
        hpField.setText(String.valueOf(pokemon.getHp()));
        String imageName = pokemon.getImageName();
        if (imageName != null && !imageName.isEmpty()) {
            ImageView imageView = (ImageView) findViewById(R.id.imagePokemonInDetail);
            imageView.setImageBitmap(BitmapFactory.decodeFile(pokemon.getImageName()));
        }
        PokemonSkill skill = pokemon.getSkills().first();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnReturnInDetail) {
            setResult(Activity.RESULT_OK, new Intent());
            finish();
        }
        if (view.getId() == R.id.btnTrainInDetail) {
            Intent trainIntent = new Intent(this, BattleSplashActivity.class);
            trainIntent.putExtra(IntentUtil.POKE_ID_INTENT, pokemon.getId());
            startActivityForResult(trainIntent, trainCode);
        }
    }
}
