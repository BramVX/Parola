package org.example;

public class Score implements ScoreStrategy{
    @Override
    public int calculateScore(int wordLength) {
        return wordLength;
    }
}
