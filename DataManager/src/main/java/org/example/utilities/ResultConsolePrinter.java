package org.example.utilities;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class ResultConsolePrinter {
    private final Semaphore consoleSemaphore = new Semaphore(1);

    public void printResultToConsole(double[] result) {
        try {
            consoleSemaphore.acquire();
            System.out.println("\n ==================== E ==================== \n");
            for (double element : result) {
                System.out.print(element + "\t");
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consoleSemaphore.release();
        }
    }

    public void printResultToConsole(double[][] result) {
        try {
            consoleSemaphore.acquire();
            System.out.println("\n ==================== MA ==================== \n");
            for (double[] row : result) {
                for (double element : row) {
                    System.out.print(element + "\t");
                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consoleSemaphore.release();
        }
    }
}
