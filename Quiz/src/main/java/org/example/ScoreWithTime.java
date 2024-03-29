package org.example;

public class ScoreWithTime implements ScoreStrategy{
    Timer timer;
    @Override
    public int calculateScore(int wordLength) {
        return (int) (wordLength + timer.seconds/5);
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
