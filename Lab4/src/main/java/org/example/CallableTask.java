package org.example;

import java.util.concurrent.Callable;

import org.example.utilities.ResultConsolePrinter;
import org.example.utilities.ResultFileWriter;

public abstract class CallableTask implements Callable<Void> {
    protected final ResultFileWriter resultFileWriter;
    protected final ResultConsolePrinter resultConsolePrinter;
    protected final Task task;

    public CallableTask(ResultFileWriter resultFileWriter, ResultConsolePrinter resultConsolePrinter, Task task) {
        this.resultFileWriter = resultFileWriter;
        this.resultConsolePrinter = resultConsolePrinter;
        this.task = task;
    }

    protected abstract Void computeAndPrintResult();

    @Override
    public Void call() {
        computeAndPrintResult();
        return null;
    }
}