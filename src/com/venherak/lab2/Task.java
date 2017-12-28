package com.venherak.lab2;

import static java.lang.Math.log;
import static java.lang.Math.random;

public class Task {
    private double processTime;

    public Task(double tau) {
        this.processTime = -log(random()) * tau;
    }

    public void proceedTask(double time) {
        processTime -= time;
    }

    public double getProcessTime() {
        return processTime;
    }

    public void setProcessTime(double processTime) {
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "Time left: " + processTime;
    }
}
