package org.example;

import java.util.concurrent.TimeUnit;

public class Timer {
    public long seconds;
    public long startTime;

    public void startTimer(){
        this.startTime = System.currentTimeMillis();
    }

    public void stopTimer(){
        this.seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime);
    }
}
