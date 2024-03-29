package org.example.scoreStrategy;

public class Score implements ScoreStrategy{
    @Override
    public int calculateScore(int wordLength, int correctAnswers) {
        return wordLength + correctAnswers;
    }
}
