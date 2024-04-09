package org.example.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ResultFileWriter {

    private final Semaphore fileSemaphore = new Semaphore(1);

    private final String fileName;

    public ResultFileWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeToResultFile(double[] result, String rowName) {

        try {
            fileSemaphore.acquire();
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(rowName + ": ");
                for (double element : result) {
                    writer.write(element + "\t");
                }
                writer.write("\n");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            fileSemaphore.release();
        }
    }

    public void writeToResultFile(double[][] result) {
        try {
            fileSemaphore.acquire();
            try (FileWriter writer = new FileWriter(fileName, true)) {

                for (double[] row : result) {
                    for (double element : row) {
                        writer.write(element + "\t");
                    }
                    writer.write("\n");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            fileSemaphore.release();
        }
    }
}