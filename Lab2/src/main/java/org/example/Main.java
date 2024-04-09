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

            Task task = new Task(MD, MT, MZ, B, D);
            ResultFileWriter resultFileWriter = new ResultFileWriter("Lab2/lab2_results/results_1.txt");
            ResultConsolePrinter resultConsolePrinter = new ResultConsolePrinter();


            Thread eThread = new Thread(() -> {
                double[] resultE = task.computeE();
                resultFileWriter.writeToResultFile(resultE, "E");
                resultConsolePrinter.printResultToConsole(resultE);
            });


            Thread maThread = new Thread(() -> {
                double[][] resultMA = task.computeMA();
                resultFileWriter.writeToResultFile(resultMA);
                resultConsolePrinter.printResultToConsole(resultMA);
            });

            eThread.start();
            maThread.start();
            eThread.join();
            maThread.join();

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("\n\n Час виконання операції: " + duration + " наносекунд");


        } catch (InterruptedException | IOException ignored) {
        }
    }
}