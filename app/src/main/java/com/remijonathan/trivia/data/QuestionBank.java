package com.remijonathan.trivia.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.remijonathan.trivia.controller.AppController;
import com.remijonathan.trivia.model.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    ArrayList<Question> questionArrayList = new ArrayList<Question>();
    private String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements.json";

    public List<Question> getQuestions(final AnswerListAsyncResponse callback) {
        final Question question = new Question();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i<response.length();i++){
                            try {
                                question.setAnswer(response.getJSONArray(i).getString(0));
                                question.setAnswer(response.getJSONArray(i).getString(1));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        Log.d("JSON", "onResponse: " + response);

                        if(null != callback){
                            callback.processFinished(questionArrayList);
                        }
                        questionArrayList.add(question);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }


}
