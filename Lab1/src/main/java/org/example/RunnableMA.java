package org.example;

import org.example.utilities.ResultConsolePrinter;
import org.example.utilities.ResultFileWriter;

public class RunnableMA extends RunnableTask {

    public RunnableMA(ResultFileWriter resultFileWriter, ResultConsolePrinter resultConsolePrinter, Task task) {
        super(resultFileWriter, resultConsolePrinter, task);
    }

    @Override
    protected void computeAndPrintResult() {
        double[][] resultMA = task.computeMA();
        resultFileWriter.writeToResultFile(resultMA);
        resultConsolePrinter.printResultToConsole(resultMA);
    }
}