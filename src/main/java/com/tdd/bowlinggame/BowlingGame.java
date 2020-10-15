package com.tdd.bowlinggame;

public class BowlingGame {

    private int score;
    private int[] game;
    private int turn;

    public BowlingGame() {
        this.game = new int[21];
        this.turn = 0;
    }

    public void roll(int numberOfPins) {
        game[turn] = numberOfPins;
        turn++;
    }

    private void calculateScore() {
        for (int i=0; i<game.length; i++) {
            score += game[i];
            if (isLastFrame(i)){
                if (isStrike(i)){
                    scoreStrike(i);
                } else {
                    score += game[i + 1];
                    score += game[i + 2];
                }
                i= game.length;
            } else {
                if (isSpare(i)){
                    scoreSpare(i);
                };
                if (isStrike(i)){
                    scoreStrike(i);
                };
            }
        }
    }

    private void scoreSpare(int i) {
        score += game[i + 1];
    }

    private void scoreStrike(int i) {
        score += game[i + 1];
        score += game[i + 2];
    }

    private boolean isLastFrame(int i) {
        return i == game.length -3;
    }

    private boolean isStrike(int i) {
        return game[i] == 10;
    }

    private Boolean isSpare(int i) {
        if(i % 2 != 0 ) {
            if(game[i-1] + game[i] == 10) {
                return true;
            }
        }
        return false;
    }

    public int getScore() {
        calculateScore();
        return score;
    }

}
