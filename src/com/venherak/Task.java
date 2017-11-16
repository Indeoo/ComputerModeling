package com.venherak;

import static java.lang.Math.random;

public class Task {
    private double proceedTime;
    private double beginTime;
    private double finishTime;
    private double firstPerformTime;
    private boolean ifPerformOnce;
    public int priority;

    private int num;

    Task(double miu, double radius, double beginTime, int num) {
        this.priority = 0;
        this.num = num;
        proceedTime =  1 / miu + radius - random() * radius * 2;
        this.beginTime = beginTime;
        this.ifPerformOnce = true;
    }

    Task(double miu, double beginTime, int num) {
        this.priority = 0;
        this.num = num;
        proceedTime =  2 / miu;
        this.beginTime = beginTime;
        this.ifPerformOnce = true;
    }

    public int getNum() {
        return num;
    }

    public void proceed(double miu) {
        proceedTime -= miu;
    }

    double getTimeInSystem() {
        return finishTime - beginTime;
    }

    double getReactionTime() {
        return firstPerformTime - beginTime;
    }

    double getActual() {
        if(getTimeInSystem() < 2) {
            return 1;
        } else {
            double actual = 2 - 0.5 * getTimeInSystem();
            if(actual < 0) {
                return 0;
            } else {
                return actual;
            }
        }
    }

    public double getProceedTime() {
        return proceedTime;
    }

    public void setFinishTime(double finishTime) {
        this.finishTime = finishTime;
    }

    public void setProceedTime(double proceedTime) {
        this.proceedTime = proceedTime;
    }

    public double getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(double beginTime) {
        this.beginTime = beginTime;
    }

    public double getFinishTime() {
        return finishTime;
    }

    public double getFirstPerformTime() {
        return firstPerformTime;
    }

    public void setFirstPerformTime(double firstPerformTime) {
        this.firstPerformTime = firstPerformTime;
    }

    public boolean ifPerformsFirst() {
        return ifPerformOnce;
    }

    public void setIfPerformOnce(boolean ifPerformOnce) {
        this.ifPerformOnce = ifPerformOnce;
    }


    @Override
    public String toString() {
        return "Time: " + proceedTime;
    }
}
