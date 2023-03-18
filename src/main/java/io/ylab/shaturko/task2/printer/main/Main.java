package io.ylab.shaturko.task2.printer.main;

import io.ylab.shaturko.task2.printer.RateLimitedPrinter;

import java.util.Scanner;

public class Main {
    private final static int LIMIT = 1_000_000_000;
    private final static String ENTER_INTERVAL = "Введите интервал в мс >> ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ENTER_INTERVAL);
        int interval = scanner.nextInt();
        RateLimitedPrinter rateLimitedPrinter = new RateLimitedPrinter(interval);
        long timePrinted = 0;
        long currentTime;

        for (int i = 0; i < LIMIT; i++) {
            currentTime = System.currentTimeMillis();
            if ((currentTime - timePrinted) > rateLimitedPrinter.getInterval()) {
                rateLimitedPrinter.print(String.valueOf(i));
                timePrinted = currentTime;
            }
        }
        scanner.close();
    }
}
