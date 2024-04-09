package org.example.utilities;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResultConsolePrinter {
    private final Lock consoleLock;

    public ResultConsolePrinter() {
        this.consoleLock = new ReentrantLock();
    }

    public void printResultToConsole(double[][] result) {
        consoleLock.lock();
        try {
            System.out.println("\n ==================== MA ==================== \n");
            for (double[] row : result) {
                for (double element : row) {
                    System.out.print(element + "\t");
                }
                System.out.println();
            }
        } finally {
            consoleLock.unlock();
        }
    }

    public void printResultToConsole(double[] result) {
        consoleLock.lock();
        try {
            System.out.println("\n\n ==================== E ==================== \n");
            for (double element : result) {
                System.out.print(element + "\t");
            }
            System.out.println();
        } finally {
            consoleLock.unlock();
        }
    }
}
