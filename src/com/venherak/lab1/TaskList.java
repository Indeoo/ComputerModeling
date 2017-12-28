package com.venherak.lab1;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class TaskList extends ArrayList<Task> {
    double getAverageTimeInSystem() {
        double average = 0;
        for (Task task : this) {
            average += task.getTimeInSystem();
        }
        return average / this.size();
    }

    double getDispersionAverageTime() {

        double average = getAverageTimeInSystem();

        double dispersion = 0;
        for (Task task : this) {
            dispersion += pow(task.getTimeInSystem() - average, 2);
        }
        return dispersion / this.size();
    }

    double getAverageReactionTime() {
        double average = 0;
        for (Task task : this) {
            average += task.getReactionTime();
        }
        return average / this.size();
    }

    double getAverageActual() {
        double average = 0;
        for (Task task : this) {
            average += task.getActual();
        }
        return average / this.size();
    }

    int countActualTasks() {
        int n = 0;
        for (Task task : this) {
            if (task.getActual() > 0) {
                n++;
            }
        }
        return n;
    }

    public Task getHighestPriorityTask() {
        int max = 10000;
        for (Task task : this) {
            if (task.priority < max) {
                max = task.priority;
            }
        }
        for (Task task : this) {
            if (max == task.priority) {
                return task;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Mx = " + getAverageTimeInSystem() + "\n" +
                "D = " + getDispersionAverageTime() + "\n" +
                "Reaction = " + getAverageReactionTime() + "\n" +
                "Ratio actual/handled= " + (double) countActualTasks() / this.size() + "\n" +
                "Actual = " + getAverageActual() + "\n" +
                "F= " + (-4 * getAverageTimeInSystem()
                + -4 * getDispersionAverageTime()
                - 1 * getAverageReactionTime()
                + 5 * (double) countActualTasks() / this.size()
                + 3 * getAverageActual()) + "\n";
    }
}
