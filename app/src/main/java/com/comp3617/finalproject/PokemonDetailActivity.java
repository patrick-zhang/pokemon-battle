package com.comp3617.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.comp3617.finalproject.model.Pokemon;
import com.comp3617.finalproject.model.PokemonSkill;
import com.comp3617.finalproject.model.RealmManager;

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
        TextView hpField = (TextView) findViewById(R.id.hpTextInDetail);
        hpField.setText(String.valueOf(pokemon.getHp()));
        String imageName = pokemon.getImageName();
        if(imageName != null && !imageName.isEmpty()) {
            ImageView imageView = (ImageView) findViewById(R.id.imagePokemonInDetail);
            int resID = getResources().getIdentifier(imageName , "drawable", getPackageName());
            imageView.setImageResource(resID);
        }
        PokemonSkill skill = pokemon.getSkills().first();
        Log.d("+++", skill.getImageName());
        TextView skillNameField = (TextView) findViewById(R.id.textSkillNameInDetail);
        skillNameField.setText(skill.getName());
        TextView damageField = (TextView) findViewById(R.id.textDamageInDetail);
        damageField.setText(String.valueOf(pokemon.getSkills().first().getDamage()));

        String iconImageName = skill.getImageName();
        if(iconImageName != null && !iconImageName.isEmpty()) {
            ImageView skillIcon = (ImageView) findViewById(R.id.imageSkillInDetail);
            int resID = getResources().getIdentifier(iconImageName , "drawable", getPackageName());
            skillIcon.setImageResource(resID);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnReturnInDetail) {
            setResult(Activity.RESULT_OK, new Intent());
            finish();
        }
    }
}
