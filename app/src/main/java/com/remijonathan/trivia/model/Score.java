package com.remijonathan.trivia.model;

public class Score {
    private int score;

    public Score(int value) {
        this.score = value;
    }

    public Score() {
    }

    public int getScore(){
        return score;
    }

    /**
     * Change the value of score based on int amount
     * @param add
     */
    public void changeScore(int add){
        score +=add;
    }

}
