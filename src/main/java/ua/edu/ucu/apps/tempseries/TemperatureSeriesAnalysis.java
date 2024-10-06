package ua.edu.ucu.apps.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private static final int CAPACITY = 10;
    private static final double NOTCORRECT = -273.0;
    private double[] temperatures;
    private int size;

    public TemperatureSeriesAnalysis() {
        this.size = 0;
        this.temperatures = new double[CAPACITY];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {

        this.temperatures = temperatureSeries;
        this.size = temperatureSeries.length;
    }

    public double average() { //tested
        if (size == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double zag = 0;
        for (int i = 0; i < size; i++) {
            zag += this.temperatures[i];
        }
        return zag / this.size;
    }

    public double deviation() { //tested
        if (size == 0) {
            throw new IllegalArgumentException("empty");
        }
        double mean = this.average();
        double rez = 0.0;

        for (int i = 0; i < this.size; i++) {
            double d = this.temperatures[i] - mean;
            rez += d * d;
        }
        return Math.sqrt(rez / this.size);
    }

    public double min() { //tested
        if (size == 0) {
            throw new IllegalArgumentException("Temperature series is empty.");
        }
        double minimum = this.temperatures[0];
        for (int i = 1; i < this.size; i++) {
            if (this.temperatures[i] < minimum) {
                minimum = this.temperatures[i];
            }
        }
        return minimum;
    }

    public double max() { //tested
        if (this.size == 0) {
            throw new IllegalArgumentException("Temperature series is empty.");
        }
        double maximum = this.temperatures[0];
        for (int i = 1; i < this.size; i++) {
            if (this.temperatures[i] > maximum) {
                maximum = this.temperatures[i];
            }
        }
        return maximum;
    }

    public double findTempClosestToZero() { //tested
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) { //tested
        if (size == 0) {
            throw new IllegalArgumentException("Temperature series is empty.");
        } else if (size == 1) {
            return this.temperatures[0];
        }
        double closest = Math.abs(this.temperatures[0] - tempValue);
        int idx = 0;
        for (int i = 1; i < this.size; i++) {
            if (Math.abs(this.temperatures[i] - tempValue) < closest) {
                idx = i;
                closest = Math.abs(this.temperatures[i] - tempValue);
            } else if (Math.abs(this.temperatures[i] - tempValue) == closest
                && this.temperatures[i] > 0 && this.temperatures[idx] < 0) {
                idx = i;
                closest = Math.abs(this.temperatures[i] - tempValue);
            }

        }
        return this.temperatures[idx];
    }

    public double[] findTempsLessThen(double tempValue) { //tested
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (this.temperatures[i] < tempValue) {
                count++;
            }
        }
        double[] correct = new double[count];
        int idx = 0;
        for (int i = 0; i < size; i++) {
            if (temperatures[i] < tempValue) {
                correct[idx] = this.temperatures[i];
                idx++;
            }
        }
        return correct;
    }

    public double[] findTempsGreaterThen(double tempValue) { //tested
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (this.temperatures[i] >= tempValue) {
                count++;
            }
        }
        double[] correct = new double[count];
        int idx = 0;
        for (int i = 0; i < size; i++) {
            if (temperatures[i] >= tempValue) {
                correct[idx] = this.temperatures[i];
                idx++;
            }
        }
        return correct;
    }

    public double[] findTempsInRange(double lowerBound, double upperBound) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (this.temperatures[i] >= lowerBound
                && this.temperatures[i] <= upperBound) {
                count++;
            }
        }
        double[] result = new double[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (this.temperatures[i] >= lowerBound
                && this.temperatures[i] <= upperBound) {
                result[index] = this.temperatures[i];
                index++;
            }
        }
        return result;
    }

    public void reset() { //tested
        this.temperatures = new double[CAPACITY];
        this.size = 0;

    }

    public double[] sortTemps() { //tested
        Arrays.sort(this.temperatures, 0, size);
        return this.temperatures;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (size == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double avgTemp = this.average();
        double devTemp = this.deviation();
        double minTemp = this.min();
        double maxTemp = this.max();

        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }

    public int addTemps(double... temps) { //tested
        for (double temp : temps) {
            if (temp < NOTCORRECT) {
                throw new InputMismatchException("Invalid temperature " + temp);
            }
        }
        if (this.size + temps.length > this.temperatures.length) {
            int newcap = (this.temperatures.length + temps.length) * 2;
            double[] newtemp = new double[newcap];
            int idx = 0;
            for (double temp : this.temperatures) {
                this.temperatures[idx] = temp;
                idx++;
            }
            this.temperatures = newtemp;
        }
        for (double temp : temps) {
            this.temperatures[this.size] = temp;
            this.size++;
        }
        return this.size;
    }

    public double[] getTemperatures() {
        return Arrays.copyOf(this.temperatures, this.size);
    }

    public int getSize() {
        return this.size;
    }
}
