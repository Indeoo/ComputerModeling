package com.venherak.lab1;

import com.venherak.lab1.handler.AbstractHandler;

public class Proccessor {
    private AbstractHandler handler;
    private double lambda;
    private double miu;
    private double inputTime;
    public  int numInputTasks;
    private double radius;

    public Proccessor(double lamda, double miu, double radius, AbstractHandler handler) {
        this.handler = handler;
        this.miu = miu;
        this.lambda = lamda;
        inputTime = 0;
         this.numInputTasks = 0;
         this.radius = radius;
    }

    void proceed(int N) {
        while (this.numInputTasks < N) {
            this.processorIn();
            this.processorOut();
            if(handler.getTasklist().size() > 0) {
                //System.out.print(" " + handler.getCurrentTask().getProcessTime());
            }
        }
    }

    void processorIn() {
        if (inputTime > 0) {
            inputTime -= lambda;
            if (inputTime <= 0) {
                handler.addTask(new Task(miu, radius));
                inputTime += poissonExponential();
                numInputTasks++;
            }
        } else {
            inputTime = poissonExponential();
        }
    }

    void processorOut() {
        handler.performCurrentTask();
    }

    double poissonExponential() {
        return - Math.log(Math.random()) / lambda;
    }
    @Override
    public String toString() {
        return "Size of queue" + handler.getQueueSize() + " currenttask " + handler.getCurrentTask();
    }
}
