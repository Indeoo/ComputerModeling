package com.venherak.lab1.handler;

import com.venherak.lab1.Task;
import com.venherak.lab1.TaskList;

public interface AbstractHandler {

    Task getCurrentTask(TaskList queue);

}
