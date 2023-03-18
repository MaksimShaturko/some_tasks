package io.ylab.shaturko.task2.printer;

public class RateLimitedPrinter {
    private int interval;

    public RateLimitedPrinter(int interval) {
        this.interval = interval;
    }

    public int getInterval() {
        return interval;
    }

    public void print(String message) {
        System.out.println(message);
    }
}
