package org.example.utilities;

public class ResultConsolePrinter {
    public void printResultToConsole(double[][] result) {
        System.out.println("\n ==================== MA ==================== \n");
        for (double[] row : result) {
            for (double element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    public void printResultToConsole(double[] result) {
        System.out.println("\n\n ==================== E ==================== \n");
        for (double element : result) {
            System.out.print(element + "\t");
        }
        System.out.println();
    }
}


