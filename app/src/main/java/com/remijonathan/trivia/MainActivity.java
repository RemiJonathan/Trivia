package com.remijonathan.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.remijonathan.trivia.data.AnswerListAsyncResponse;
import com.remijonathan.trivia.data.QuestionBank;
import com.remijonathan.trivia.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*private TextView questionText;
    private Button backButton;
    private Button falseButton;
    private Button trueButton;
    private Button nextButton;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*questionText = findViewById(R.id.question_text);
        backButton= findViewById(R.id.back_button);
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);*/

        final String[] answer = new String[1];

        final List<Question> questionList = new QuestionBank().getQuestions(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {

            }
        });

        int size = questionList.size();

        Toast.makeText(this,Integer.toString(size), Toast.LENGTH_LONG).show();

        /*backButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
*/


    }


    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                //TODO: Back button does something.
                break;
            case R.id.false_button:
                //TODO: False button claims that statement is false
                break;
            case R.id.true_button:
                //TODO: True button claims that statement is true
                break;
            case R.id.next_button:
                //TODO: switches to next question
                break;
        }
    }*/
}
