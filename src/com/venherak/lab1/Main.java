package com.venherak.lab1;

//4. ВенгеракМ(2) -4 -4  -1   5   3  2     4 Rand, FB

import com.venherak.lab1.handler.Rand;

public class Main {

    public static void main(String[] args) {
        double lambda = 0;
        double miu = 0;
        double M = 2;
        int N = 0;
/*        BufferedReader bif = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Input λ (Input intensity)");
            lambda = Double.parseDouble(bif.readLine());
            System.out.println("Input μ (Output intensity)");
            miu = Double.parseDouble(bif.readLine());
            System.out.println("Input N (Number of Tasks)");
            N = Integer.parseInt(bif.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        lambda = 0.1;
        miu = 0.1;
        N = 1000;
        System.out.println(lambda + " " + miu + N);
        System.out.println("Кількість задач: " + N);
        Proccessor proccessor = new Proccessor(lambda, miu, M/2, new Rand(miu));
        proccessor.proceed(N);
        Task task = new Task(miu, M/2);
        System.out.println(task.getProcessTime());
        System.out.println(- Math.log(Math.random()) / lambda);
    }
}