package org.example;

import org.example.utilities.ResultConsolePrinter;
import org.example.utilities.ResultFileWriter;

public class RunnableE extends RunnableTask {


    public RunnableE(ResultFileWriter resultFileWriter, ResultConsolePrinter resultConsolePrinter, Task task) {
        super(resultFileWriter, resultConsolePrinter, task);
    }

    @Override
    protected void computeAndPrintResult() {
        double[] resultE = task.computeE();
        resultFileWriter.writeToResultFile(resultE, "E");
        resultConsolePrinter.printResultToConsole(resultE);
    }
}