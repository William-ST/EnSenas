package me.doapps.essenas.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by William_ST on 29/11/15.
 */
public class PreferencesUtil {

    private static final String PREFERENCE_NAME = "ensenas_preferences";
    private int PRIVATE_MODE = 0;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public static final String DATA_CONFIG = "data_config";

    public PreferencesUtil(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void setSpeedConfig(int speed){
        editor.putInt(DATA_CONFIG, speed);
        editor.commit();
    }

    public int getSpeedConfig(){
        return preferences.getInt(DATA_CONFIG, 3);
    }
}
