package com.remijonathan.trivia.data;

import com.remijonathan.trivia.model.Question;

import java.util.ArrayList;

public interface AnswerListAsyncResponse {
    void processFinished(ArrayList<Question> questionArrayList);
}
