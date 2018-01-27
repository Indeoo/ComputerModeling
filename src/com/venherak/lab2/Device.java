package com.venherak.lab2;

import java.util.*;

import static java.lang.Math.random;

public class Device {
    String name;
    private List<Task> currentTasks;
    private InputQueue beginQueue;
    private AndElement andElement;
    private double tau;
    public double workTime;
    public double workTime2;
    private boolean free;
    private Map<Device, Double> nextDevices;

    public Device() {
        this.currentTasks = new ArrayList<>();
        this.workTime = 0;
        this.nextDevices = new HashMap<>();
    }

    public Device(double tau, InputQueue inputQueue, AndElement andElement, String name) {
        this.currentTasks = new ArrayList<>();
        this.tau = tau;
        this.beginQueue = inputQueue;
        this.andElement = andElement;
        this.workTime = 0;
        this.nextDevices = new HashMap<>();
        this.name = name;
    }

    public Device(double tau, int inputCounter, int andCounter, int andMax, String name) {
        this.currentTasks = new ArrayList<>();
        this.tau = tau;
        this.beginQueue = new InputQueue(inputCounter);
        this.andElement = new AndElement(andCounter, andMax);
        this.workTime = 0;
        this.nextDevices = new HashMap<>();
        this.name = name;
    }

    public boolean checkFree() {
        return currentTasks.size() == 0;
    }

    public List<Task> getCurrentTasks() {
        return currentTasks;
    }

    public void proceed(double time) {

        if(currentTasks.size() > 0) {
            if (!this.checkFree()) {
                workTime += time;
            }
            if(currentTasks.size() == 2) {
                workTime2 +=time;
            }
        }

        for (Task task : currentTasks) {
            if (task.getProcessTime() > 0) {
                task.proceedTask(time);
            } else {
                getNextDevice().beginQueue.incrementCounter();
                this.andElement.incrementCounter();
                currentTasks.remove(task);
                break;
            }
        }
        if (beginQueue.getCounter() > 0 & andElement.getCounter() > 0) {
            beginQueue.decrementCounter();
            andElement.decrementCounter();
            currentTasks.add(new Task(tau));
        }
    }

    public Device getNextDevice() {
        double random = random();
        double save = 0;
        for (Map.Entry<Device, Double> entry : nextDevices.entrySet()) {
            save += entry.getValue();

            if (save > random) {
                return entry.getKey();
            }
        }
        return null;
    }

    public double getLoadCoeff(double systemTime) {
        return workTime / systemTime;
    }

    public void setCurrentTasks(List<Task> currentTasks) {
        this.currentTasks = currentTasks;
    }

    public InputQueue getBeginQueue() {
        return beginQueue;
    }

    public void setBeginQueue(InputQueue beginQueue) {
        this.beginQueue = beginQueue;
    }

    public AndElement getAndElement() {
        return andElement;
    }

    public void setAndElement(AndElement andElement) {
        this.andElement = andElement;
    }

    public double getTau() {
        return tau;
    }

    public void setTau(double tau) {
        this.tau = tau;
    }

    public Map<Device, Double> getNextDevices() {
        return nextDevices;
    }

    public void setNextDevices(HashMap<Device, Double> nextDevices) {
        this.nextDevices = nextDevices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(double workTime) {
        this.workTime = workTime;
    }

    public void setNextDevices(Map<Device, Double> nextDevices) {
        this.nextDevices = nextDevices;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return name + " Average handle time: " + tau + " " + beginQueue + " " + andElement + " " ;
    }
}
