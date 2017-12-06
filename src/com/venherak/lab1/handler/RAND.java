package com.venherak.lab1.handler;

import com.venherak.lab1.Task;
import com.venherak.lab1.TaskList;

public class RAND implements AbstractHandler {
    @Override
    public Task getCurrentTask(TaskList queue) {
        return queue.get(0);
    }
}
