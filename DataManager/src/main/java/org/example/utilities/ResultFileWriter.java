package org.example.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ResultFileWriter {

    private final String fileName;

    public ResultFileWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeToResultFile(double[] result, String rowName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(rowName + ": ");
            for (double element : result) {
                writer.write(element + "\t");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToResultFile(double[][] result) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (double[] row : result) {
                for (double element : row) {
                    writer.write(element + "\t");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}