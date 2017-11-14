package com.venherak.lab1;

public class Task {
    private double processTime;

    Task(double miu, double e) {
        this.processTime =  (Math.random() * 2* e + 1 / miu - e);
    }

    public void processTask(double processTime) {
        this.processTime -= processTime;
    }
    public double getProcessTime() {
        return processTime;
    }

    @Override
    public String toString() {
        return "Time " + processTime;
    }
}
