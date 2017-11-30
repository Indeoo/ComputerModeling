package com.venherak;

import com.venherak.handler.AbstractHandler;

import static com.venherak.Main.getInputInterval;

public class Processor {
    private double lambda;
    private double miu;
    private double radius;
    private AbstractHandler handler;
    private TaskList queue;

    public Processor(double lambda, double miu, double radius, AbstractHandler handler) {
        this.handler = handler;
        this.radius = radius;
        this.lambda = lambda;
        this.miu = miu;
        this.queue = new TaskList();
    }

    TaskList start(int N) {
        double systemTime = 0;
        double interval = 0;
        int inputedTasks = 0;
        TaskList finishedTasks = new TaskList();
        Task currentTask;
        double m = 0;

        while (finishedTasks.size() < N) {
            if (interval <= 0) {
                if (inputedTasks % 50 == 0 & inputedTasks != 0) {
                    queue.add(new Task(miu, systemTime, inputedTasks));
                } else {
                    queue.add(new Task(miu, radius, systemTime, inputedTasks));
                }
                inputedTasks++;
                interval = getInputInterval(lambda);
            }

            if (queue.size() > 0) {
                currentTask = handler.getCurrentTask(queue);
                if (currentTask.ifPerformsFirst()) {
                    currentTask.setIfPerformOnce(false);
                    currentTask.setFirstPerformTime(systemTime);
                }
                currentTask.proceed(0.001);
                if (currentTask.getProceedTime() <= 0) {
                    currentTask.setFinishTime(systemTime);
                    finishedTasks.add(currentTask);
                    queue.remove(currentTask);
                }
            }
            systemTime += 0.001;
            interval -= 0.001;
            if(queue.size() > 0) {
                m += queue.size() - 1;
            }
        }
        m /= (systemTime * 1000);
        System.out.println(m);
        return finishedTasks;
    }
}
