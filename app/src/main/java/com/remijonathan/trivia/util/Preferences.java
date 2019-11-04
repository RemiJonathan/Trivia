package com.remijonathan.trivia.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private SharedPreferences sharedPreferences;

    public Preferences(Activity activity){
        sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
    }

    public void saveHighScore(int currentScore){
        int lastScore = sharedPreferences.getInt("high_score", 0);

        if (currentScore > lastScore) sharedPreferences.edit().putInt("high_score", currentScore).apply();
    }

    public int getHighScore(){
        return sharedPreferences.getInt("high_score",0);
    }


}
