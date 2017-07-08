package com.comp3617.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.comp3617.finalproject.model.RealmManager;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void onClick (View view) {
        if (view.getId() == R.id.btnDeleteAll) {
            RealmManager.deletePokemon();
        }
    }
}
