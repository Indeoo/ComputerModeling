package com.venherak.lab2;

public class AndElement {
    private int counter;
    private int counterMax;

    public AndElement() {

    }

    public AndElement(int counter, int counterMax) {
        this.counter = counter;
        this.counterMax = counterMax;
    }

    public void incrementCounter() {
        counter++;
    }

    public void decrementCounter() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounterMax() {
        return counterMax;
    }

    public void setCounterMax(int counterMax) {
        this.counterMax = counterMax;
    }

    @Override
    public String toString() {
        return "AndState: " + counter + "/" + counterMax;
    }
}
