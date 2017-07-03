package com.comp3617.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokemon);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddPokemon: {
                break;
            }
            default: break;
        }
    }
}
