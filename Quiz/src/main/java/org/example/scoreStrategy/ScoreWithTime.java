package org.example.scoreStrategy;

import org.example.Timer;

public class ScoreWithTime implements ScoreStrategy{
    Timer timer;
    @Override
    public int calculateScore(int wordLength) {
        return (int) (wordLength - timer.getSeconds()/5 + 30);
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
