package com.remijonathan.trivia.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.remijonathan.trivia.data.QuestionBank;
import com.remijonathan.trivia.model.Question;

import java.lang.reflect.Type;
import java.util.List;

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

    public void saveCurrentScore(int currentScore){
        sharedPreferences.edit().putInt("current_score", currentScore).apply();
    }

    public int getCurrentScore(){
        return sharedPreferences.getInt("current_score",0);
    }

    public void saveIndex(int questionIndex){
        sharedPreferences.edit().putInt("question_index", questionIndex).apply();
    }

    public int loadIndex(){
        return sharedPreferences.getInt("question_index",0);
    }

    public void saveQuestions(List<Question> questions){
        Gson gson = new Gson();
        sharedPreferences.edit().putString("questions", gson.toJson(questions)).apply();
    }

    public List<Question> loadQuestions(){
        Gson gson = new Gson();

        //Create a Type Token for List<Question>
        Type questionListType = new TypeToken<List<Question>>() {}.getType();

        return gson.fromJson(sharedPreferences.getString("questions", null), questionListType);
    }
}
