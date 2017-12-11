
package com.venherak;

import com.venherak.handler.FB;
import com.venherak.handler.RAND;

import static java.lang.Math.log;
import static java.lang.Math.random;

public class Main {
    private static double lambda = 0.2;
    private static double miu = 1;
    private static int N = 1000;
    private static int M = 2;

    public static void main(String args[]) {
        System.out.println("N = " + N);
        System.out.println("lambda = " + lambda);
        System.out.println("miu = " + miu);
        System.out.println();

        System.out.println("RAND");
        Processor processor1 = new Processor(lambda, miu, M / 2, new RAND());
        TaskList finishedTasks1 = processor1.start(N);
        System.out.println(finishedTasks1.toString());
        System.out.println("RAND: EVERY 50");
        TaskList everyFiftyList1 = new TaskList();
        for (Task task : finishedTasks1) {
            if (task.getNum() % 50 == 0) {
                everyFiftyList1.add(task);
            }
        }
        System.out.println(everyFiftyList1.toString());

        System.out.println("FB");
        Processor processor2 = new Processor(lambda, miu, M / 2, new FB(100, 1000));
        TaskList finishedTasks2 = processor2.start(N);
        System.out.println(finishedTasks2.toString());
        System.out.println("FB: EVERY 50");
        TaskList everyFiftyList2 = new TaskList();
        for (Task task : finishedTasks2) {
            if (task.getNum() % 50 == 0) {
                everyFiftyList2.add(task);
            }
        }
        System.out.println(everyFiftyList2.toString());
    }

    static double getInputInterval(double lambda) {
        return -log(random()) / lambda;
    }
}
