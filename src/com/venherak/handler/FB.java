package com.venherak.handler;

import com.venherak.Task;
import com.venherak.TaskList;

public class FB implements AbstractHandler {
    private Task currentTask;
    private int innerTime = 0;
    private int k = 100;

    @Override
    public Task getCurrentTask(TaskList queue) {
        currentTask = queue.getHighestPriorityTask();
        if(innerTime < 1) {
            innerTime++;
        } else {
            if(currentTask.priority == k) {

            } else {
                currentTask.priority++;
                innerTime = 0;
            }
        }
        return currentTask;
    }
}
