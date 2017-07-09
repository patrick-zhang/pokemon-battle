package com.comp3617.finalproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Patrick on 7/8/2017.
 */

public class PrefUtil {
    public static final String PREF_KEY_APP = "POKEMON_BATTLE_PREF";
    public static final String PREF_KEY_INITIALIZED = "INITIALIZED";
    private Context context;
    private SharedPreferences sharedPreferences;
    public PrefUtil (Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_KEY_APP, Context.MODE_APPEND);
    }

    public void setBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    public boolean getBoolean (String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, false);
    }
}
