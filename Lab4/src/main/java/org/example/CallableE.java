package org.example;


import org.example.utilities.ResultConsolePrinter;
import org.example.utilities.ResultFileWriter;

public class CallableE extends CallableTask {

    public CallableE(ResultFileWriter resultFileWriter, ResultConsolePrinter resultConsolePrinter, Task task) {
        super(resultFileWriter, resultConsolePrinter, task);
    }

    @Override
    protected Void computeAndPrintResult() {
        double[] resultE = task.computeE();
        resultFileWriter.writeToResultFile(resultE, "E");
        resultConsolePrinter.printResultToConsole(resultE);
        return null;
    }
}