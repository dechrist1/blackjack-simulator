package com.grosserhund.util;

public class StopWatch {

    private long startTimeMillis;
    private long totalTimeMillis;

    public void start() {
        this.startTimeMillis = System.currentTimeMillis();
    }

    public void stop() {
        this.totalTimeMillis = System.currentTimeMillis() - this.startTimeMillis;
    }

    public long getTotalTimeMilliSeconds() {
        return this.totalTimeMillis;
    }

    public double getTotalTimeSeconds() {
        return this.totalTimeMillis / 1000.0;
    }

}
