package com.venherak.handler;

import com.venherak.Task;
import com.venherak.TaskList;

public class RAND implements AbstractHandler {
    @Override
    public Task getCurrentTask(TaskList queue) {
        return queue.get(0);
    }
}
