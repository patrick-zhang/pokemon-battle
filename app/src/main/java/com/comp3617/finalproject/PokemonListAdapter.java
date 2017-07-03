package com.comp3617.finalproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.comp3617.finalproject.model.Pokemon;

import java.util.List;

/**
 * Created by Patrick on 6/11/2017.
 */

public class PokemonListAdapter extends ArrayAdapter<Pokemon> {
    private Context context;
    private List<Pokemon> pokemonList;
    public PokemonListAdapter(@NonNull Context context, List<Pokemon> pokemonList) {
        super(context, 0, pokemonList);
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View pokemonView = inflater.inflate(R.layout.item_pokemon, parent, false);
            TextView pokemonRowName = (TextView) pokemonView.findViewById(R.id.pokemonRowName);
            pokemonRowName.setText(pokemonList.get(position).getName());
            return pokemonView;
        } else {
            return convertView;
        }
    }
}
