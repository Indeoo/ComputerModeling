package com.venherak.lab3;

public class Main {

    public static void main(String[] args) {
        System.out.println("LAB 2");
        com.venherak.lab2.Main.main(null);
        System.out.println();
        String[] devices = {"Core 1", "Core 2", "NB", "SB", "RAM", "VP", "МА", "KD"};
        int[][] startStateMatrix = {
                {0, 1, 0}, // Core 1
                {0, 0, 1}, // Core 2
                {0, 1, 0}, // NB
                {0, 1, 0}, // SB
                {0, 1, 0}, // RAM
                {0, 1, 0}, // VP
                {0, 1, 0}, // МА
                {0, 0, 1}, // KD
        };
        double[] tau = {5, 5, 2, 7, 3, 4, 5, 1};
        double[][] probabilities = {
                //          Core 1   Core2  NB    SB    RAM     VP    МА    KD
                /*Core 1*/  {0,     0,      1,    0,    0,     0,   0,    0,},
                /*Core 2*/  {0,     0,      1,    0,    0,     0,   0,    0,},
                /*NB*/      {0.3,   0.1,    0,    0.2,  0.4,   0,   0,    0,  },
                /*SB*/      {0,     0,      0,    0,    0,     0.4, 0.4,  0.2,  },
                /*RAM*/     {0,     0,      1,    0,    0,     0,   0,    0,  },
                /*VP*/      {0.6,     0.4,  0,    0,    0,     0,   0,    0,  },
                /*МА*/      {0,     0,      0,    1,    0,     0,   0,    0,  },
                /*KD*/      {0,     0,      0,    1,    0,     0,   0,    0,  },
        };

        System.out.println("Lab 3\n");

        Tree tree = new Tree();
        tree.generateTree(startStateMatrix, probabilities, tau);


        Process p = new Process(tree.getStateMap());
        double[] loadingCoefficient = p.calculateRo();

        for (int i = 0; i < loadingCoefficient.length; i++) {
            System.out.printf(devices[i]+ " - " + loadingCoefficient[i] + "\n");
        }

        System.out.println(StateFactory.getStates().size());
    }
}
