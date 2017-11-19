package com.venherak.handler;

import com.venherak.Task;
import com.venherak.TaskList;

public class FB implements AbstractHandler {
    private Task currentTask;
    private int innerTime = 0;
    private int queueSize;
    private int quantTime;

    public FB(int queueSize, int quantTime) {
        this.quantTime = quantTime;
        this.queueSize = queueSize;
    }

    @Override
    public Task getCurrentTask(TaskList queue) {
        currentTask = queue.getHighestPriorityTask();
        if(innerTime < quantTime) {
            innerTime++;
        } else {
            if(currentTask.priority != queueSize) {
                currentTask.priority++;
                innerTime = 0;
            }
        }
        return currentTask;
    }
}
