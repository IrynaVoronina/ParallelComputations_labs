package org.example;

import org.example.utilities.DataReader;
import org.example.utilities.ResultConsolePrinter;
import org.example.utilities.ResultFileWriter;

import java.io.IOException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        try {
            DataReader dataReader = new DataReader();

            double[][] MD = dataReader.readMatrixFromFile(FileName.MD.getFileName());
            double[][] MT = dataReader.readMatrixFromFile(FileName.MT.getFileName());
            double[][] MZ = dataReader.readMatrixFromFile(FileName.MZ.getFileName());

            double[] B = dataReader.readVectorFromFile(FileName.B.getFileName());
            double[] D = dataReader.readVectorFromFile(FileName.D.getFileName());

            ResultFileWriter resultFileWriter = new ResultFileWriter("Lab4/lab4_results/results_4.txt");
            ResultConsolePrinter resultConsolePrinter = new ResultConsolePrinter();
            Task task = new Task(MD, MT, MZ, B, D);

            long startTime = System.nanoTime();

            CallableMA callableMA = new CallableMA(resultFileWriter, resultConsolePrinter, task);
            CallableE callableE = new CallableE(resultFileWriter, resultConsolePrinter, task);

            FutureTask<Void> futureTaskMA = new FutureTask<>(callableMA);
            FutureTask<Void> futureTaskE = new FutureTask<>(callableE);

            Thread threadMA = new Thread(futureTaskMA);
            Thread threadE = new Thread(futureTaskE);
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