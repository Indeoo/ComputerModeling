package com.venherak.lab2;

public class InputQueue {
    private int counter;

    public InputQueue() {

    }

    public InputQueue(int counter) {
        this.counter = counter;
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

    @Override
    public String toString() {
        return "InputState: " + counter;
    }
}
