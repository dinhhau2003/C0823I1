package com.example.caculator.model;

public class Caculator {
    private double  usd;
    private double  rate;
    private double  result;

    public Caculator() {
    }

    public Caculator(double usd, double rate, double result) {
        this.usd = usd;
        this.rate = rate;
        this.result = result;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
