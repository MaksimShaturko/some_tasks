package io.ylab.shaturko.task2.stats_accumulating.main;

import io.ylab.shaturko.task2.stats_accumulating.StatsAccumulator;
import io.ylab.shaturko.task2.stats_accumulating.impl.StatsAccumulatorImpl;

import java.util.Scanner;

public class Main {
    private final static String ENTER_ITERATIONS = "Введите количество итераций цикла >> ";
    private final static String ENTER_NUMBER = "Введите число >> ";
    private final static String COUNT = "count = ";
    private final static String MIN = "min = ";
    private final static String MAX = "max = ";
    private final static String AVG = "average = ";

    public static void main(String[] args) {
        StatsAccumulator statsAccumulator = new StatsAccumulatorImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_ITERATIONS);
        int iterations = scanner.nextInt();

        for(int i = 1; i <= iterations; i++) {
            System.out.println(ENTER_NUMBER);
            int number = scanner.nextInt();
            statsAccumulator.add(number);
            System.out.println(COUNT + statsAccumulator.getCount());
            System.out.println(MIN + statsAccumulator.getMin());
            System.out.println(MAX + statsAccumulator.getMax());
            System.out.println(AVG + statsAccumulator.getAvg());
        }
        scanner.close();
    }
}
