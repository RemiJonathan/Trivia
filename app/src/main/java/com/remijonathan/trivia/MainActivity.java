package com.remijonathan.trivia;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.remijonathan.trivia.data.AnswerListAsyncResponse;
import com.remijonathan.trivia.data.QuestionBank;
import com.remijonathan.trivia.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView completedIndex;
    private TextView questionText;
    private ImageButton backButton;
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;

    List<Question> questionList;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        completedIndex = findViewById(R.id.completed_index);
        questionText = findViewById(R.id.question_text);
        backButton= findViewById(R.id.back_button);
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);

        questionList = new QuestionBank().getQuestions(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {
                questionText.setText(questionArrayList.get(index).getAnswer());
                completedIndex.setText(String.format("%d out of %d", index+1, questionArrayList.size()));
            }
        });

        backButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                //TODO: Back button does something.
                //Debug
                //Toast.makeText(this,"Back", Toast.LENGTH_SHORT).show();
                index--;
                updateQuestion();
                break;

            case R.id.false_button:
                //TODO: False button claims that statement is false
                //Debug
                //Toast.makeText(this,"False", Toast.LENGTH_SHORT).show();
                testQuestion(false);
                break;

            case R.id.true_button:
                //TODO: True button claims that statement is true
                //Debug
                //Toast.makeText(this,"True", Toast.LENGTH_SHORT).show();
                testQuestion(true);
                break;

            case R.id.next_button:
                //TODO: switches to next question
                //Debug
                //Toast.makeText(this,"Next", Toast.LENGTH_SHORT).show();
                index++;
                updateQuestion();
                break;
        }
    }

    void updateQuestion(){
        if (index < 0) index = questionList.size()-1;
        if(index > questionList.size()-1) index = 0;
            questionText.setText(questionList.get(index % questionList.size()).getAnswer());

            completedIndex.setText(String.format("%d out of %d", (index+1), questionList.size()));
    }

    void testQuestion(boolean response){
        if (response == questionList.get(index).isAnswerTrue()){
            //TODO: Answer correct
            shakeAnimation(true);
            updateQuestion();
            Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();

        }else {
            //TODO: Answer incorrect
            shakeAnimation(false);
            updateQuestion();
            Toast.makeText(this,"Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    private void shakeAnimation(final boolean exactitude){
        Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake_animation);
        final CardView cardView = findViewById(R.id.question_card);
        cardView.setAnimation(shake);

        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (exactitude) {
                    cardView.setCardBackgroundColor(Color.GREEN);
                } else {
                    cardView.setCardBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardView.setCardBackgroundColor(Color.WHITE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
