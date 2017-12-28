package com.venherak.lab2;

import java.util.*;

import static java.lang.Math.random;

public class Device {
    String name;
    private List<Task> currentTasks;
    private InputQueue beginQueue;
    private AndQueue andQueue;
    private double tau;
    private double workTime;
    private Map<Device, Double> nextDevices;

    public Device() {
        this.currentTasks = new ArrayList<>();
        this.workTime = 0;
        this.nextDevices = new HashMap<>();
    }

    public Device(double tau, InputQueue inputQueue, AndQueue andQueue, String name) {
        this.currentTasks = new ArrayList<>();
        this.tau = tau;
        this.beginQueue = inputQueue;
        this.andQueue = andQueue;
        this.workTime = 0;
        this.nextDevices = new HashMap<>();
        this.name = name;
    }

    public Device(double tau, int inputCounter, int andCounter, int andMax, String name) {
        this.currentTasks = new ArrayList<>();
        this.tau = tau;
        this.beginQueue = new InputQueue(inputCounter);
        this.andQueue = new AndQueue(andCounter, andMax);
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
        if (!this.checkFree()) {
            workTime += time;
        }

        for (Task task : currentTasks) {
            if (task.getProcessTime() > 0) {
                task.proceedTask(time);
            } else {
                getNextDevice().beginQueue.incrementCounter();
                this.andQueue.incrementCounter();
                currentTasks.remove(task);
                break;
            }
        }
        if (beginQueue.getCounter() > 0 & andQueue.getCounter() > 0) {
            beginQueue.decrementCounter();
            andQueue.decrementCounter();
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

    public AndQueue getAndQueue() {
        return andQueue;
    }

    public void setAndQueue(AndQueue andQueue) {
        this.andQueue = andQueue;
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
        return name + " Average handle time: " + tau + " " + beginQueue + " " + andQueue + " " ;
    }
}
