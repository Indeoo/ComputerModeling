package com.venherak.handler;

import com.venherak.Task;
import com.venherak.TaskList;

public interface AbstractHandler {

    Task getCurrentTask(TaskList queue);

}
