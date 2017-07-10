package com.comp3617.finalproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.comp3617.finalproject.model.PokemonSkill;

import java.util.List;

/**
 * Created by Patrick on 7/9/2017.
 */

public class PokemonSkillListAdapter extends ArrayAdapter<PokemonSkill> {
    private Context context;
    private List<PokemonSkill> pokemonSkillList;
    private TextView tvNameInPokemonSkillRow;
    private TextView tvDamageInPokemonSkillRow;
    private ImageView imgIconInPokemonSkillRow;

    public PokemonSkillListAdapter(@NonNull Context context, List<PokemonSkill> pokemonSkillList) {
        super(context, 0, pokemonSkillList);
        this.context = context;
        this.pokemonSkillList = pokemonSkillList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View pokemonSkillView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            pokemonSkillView = inflater.inflate(R.layout.item_pokemon_skill, parent, false);
        } else {
            pokemonSkillView = convertView;
        }
        PokemonSkill pokemonSkill = pokemonSkillList.get(position);
        tvNameInPokemonSkillRow = (TextView) pokemonSkillView.findViewById(R.id.tvNameInPokemonSkillRow);
        tvNameInPokemonSkillRow.setText(pokemonSkill.getName());
        tvDamageInPokemonSkillRow = (TextView) pokemonSkillView.findViewById(R.id.tvDamageInPokemonSkillRow);
        tvDamageInPokemonSkillRow.setText(String.valueOf(pokemonSkill.getDamage()));
        String imageName = pokemonSkill.getImageName();
        if(imageName != null && !imageName.isEmpty()) {
            imgIconInPokemonSkillRow = (ImageView) pokemonSkillView.findViewById(R.id.imgIconInPokemonSkillRow);
            int resID = pokemonSkillView.getResources().getIdentifier(imageName , "drawable", getContext().getPackageName());
            imgIconInPokemonSkillRow.setImageResource(resID);
        }
        return pokemonSkillView;
    }
}
