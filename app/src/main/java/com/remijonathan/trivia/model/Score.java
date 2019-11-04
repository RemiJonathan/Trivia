package com.remijonathan.trivia.model;

public class Score {
    private int score;

    public Score(int value) {
        this.score = value;
    }

    public Score() {
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    /**
     * Change the value of score based on int amount
     * @param add amount to be added to the score, pass a negative integer to lower the score
     */
    public void changeScore(int add){
        score +=add;
    }

}
