package org.example;

import org.example.utilities.DataReader;
import org.example.utilities.ResultConsolePrinter;
import org.example.utilities.ResultFileWriter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
            ResultFileWriter resultFileWriter = new ResultFileWriter("Lab3/lab3_results/results_3.txt");
            ResultConsolePrinter resultConsolePrinter = new ResultConsolePrinter();
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            executorService.execute(() -> {
                double[] resultE = task.computeE();
                resultFileWriter.writeToResultFile(resultE, "E");
                resultConsolePrinter.printResultToConsole(resultE);
            });

            executorService.execute(() -> {
                double[][] resultMA = task.computeMA();
                resultFileWriter.writeToResultFile(resultMA);
                resultConsolePrinter.printResultToConsole(resultMA);
            });

            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("\n\n Час виконання операції: " + duration + " наносекунд");


        } catch (IOException | InterruptedException ignored) {
        }
    }
}
