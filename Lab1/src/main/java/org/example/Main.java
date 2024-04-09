package org.example;

import org.example.utilities.DataReader;
import org.example.utilities.ResultConsolePrinter;
import org.example.utilities.ResultFileWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            DataReader dataReader = new DataReader();

            double[][] MD = dataReader.readMatrixFromFile(FileName.MD.getFileName());
            double[][] MT = dataReader.readMatrixFromFile(FileName.MT.getFileName());
            double[][] MZ = dataReader.readMatrixFromFile(FileName.MZ.getFileName());

            double[] B = dataReader.readVectorFromFile(FileName.B.getFileName());
            double[] D = dataReader.readVectorFromFile(FileName.D.getFileName());

            ResultFileWriter resultFileWriter = new ResultFileWriter("Lab1/lab1_results/results_1.txt");
            ResultConsolePrinter resultConsolePrinter = new ResultConsolePrinter();
            Task task = new Task(MD, MT, MZ, B, D);

            long startTime = System.nanoTime();

            Thread threadMA = new Thread(new RunnableMA(resultFileWriter, resultConsolePrinter, task));
            Thread threadE = new Thread(new RunnableE(resultFileWriter, resultConsolePrinter, task));

            threadMA.start();
            threadE.start();

            threadMA.join();
            threadE.join();

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("\n\n Час виконання операції: " + duration + " наносекунд");

        } catch (IOException |
                 InterruptedException ignored) {
        }
    }
}