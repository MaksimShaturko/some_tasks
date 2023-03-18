package io.ylab.shaturko.task2.stats_accumulating.impl;

import io.ylab.shaturko.task2.stats_accumulating.StatsAccumulator;

public class StatsAccumulatorImpl implements StatsAccumulator {
    private int count;
    private int max;
    private int min;
    private double average;

    public StatsAccumulatorImpl() {
        this.count = 0;
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
    }

    @Override
    public void add(int value) {
        calculateCount(value);
        calculateMin(value);
        calculateMax(value);
        calculateAvg(value);
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
       return max;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Double getAvg() {
        return average;
    }

    private void calculateMin(int value) {
        if (value < min) {
            min = value;
        }
    }

    private void calculateMax(int value) {
        if (value > max) {
            max = value;
        }
    }

    private void calculateCount(int value) {
        count++;
    }

    private void calculateAvg(int value) {
        if(count == 1) {
            average = value;
        } else {
            average = (average * (count - 1) + value) / count;
        }
    }
}
