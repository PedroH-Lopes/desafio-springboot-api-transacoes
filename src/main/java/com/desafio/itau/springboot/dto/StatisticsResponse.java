package com.desafio.itau.springboot.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponse {
    private final long count;
    private final  double sum;
    private final double avg;
    private final double min;
    private final double max;

    public StatisticsResponse(long count, double sum, double avg, double min, double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
