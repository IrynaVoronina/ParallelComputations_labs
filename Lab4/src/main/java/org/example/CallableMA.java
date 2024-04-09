package org.example;


import org.example.utilities.ResultConsolePrinter;
import org.example.utilities.ResultFileWriter;

public class CallableMA extends CallableTask {

    public CallableMA(ResultFileWriter resultFileWriter, ResultConsolePrinter resultConsolePrinter, Task task) {
        super(resultFileWriter, resultConsolePrinter, task);
    }

    @Override
    protected Void computeAndPrintResult() {
        double[][] resultMA = task.computeMA();
        resultFileWriter.writeToResultFile(resultMA);
        resultConsolePrinter.printResultToConsole(resultMA);
        return null;
    }
}