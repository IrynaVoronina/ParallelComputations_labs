package org.example.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResultFileWriter {
    private final String fileName;
    private final Lock fileLock;

    public ResultFileWriter(String fileName) {
        this.fileName = fileName;
        this.fileLock = new ReentrantLock();
    }

    public void writeToResultFile(double[] result, String rowName) {
        fileLock.lock();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(rowName + ": ");
            for (double element : result) {
                writer.write(element + "\t");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileLock.unlock();
        }
    }

    public void writeToResultFile(double[][] result) {
        fileLock.lock();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (double[] row : result) {
                for (double element : row) {
                    writer.write(element + "\t");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileLock.unlock();
        }
    }
}
