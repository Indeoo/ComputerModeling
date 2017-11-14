package com.venherak.lab1.handler;

import com.venherak.lab1.Task;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHandler {
    private int currentTaskId;
    private List<Task> tasklist;
    double miu;

    public AbstractHandler(double miu) {
        tasklist = new ArrayList<>();
        this.miu = miu;
    }
    public abstract void performCurrentTask();
    public Task getCurrentTask() {
        return tasklist.get(currentTaskId);
    }
    public int getQueueSize() {
        return tasklist.size();
    }
    public void addTask(Task task) {
        tasklist.add(task);
    }
    public void setCurrentTaskId(int currentTaskId) {
        this.currentTaskId = currentTaskId;
    }
    public List<Task> getTasklist() {
        return tasklist;
    }
    public int getCurrentTaskId() {
        return currentTaskId;
    }
}
