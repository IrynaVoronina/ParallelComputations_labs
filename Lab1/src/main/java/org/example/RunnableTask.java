package org.example;

import org.example.utilities.ResultConsolePrinter;
import org.example.utilities.ResultFileWriter;

public abstract class RunnableTask implements Runnable {
    protected final ResultFileWriter resultFileWriter;
    protected final ResultConsolePrinter resultConsolePrinter;
    protected final Task task;

    public RunnableTask(ResultFileWriter resultFileWriter, ResultConsolePrinter resultConsolePrinter, Task task) {
        this.resultFileWriter = resultFileWriter;
        this.resultConsolePrinter = resultConsolePrinter;
        this.task = task;
    }

    protected abstract void computeAndPrintResult();

    @Override
    public void run() {
        computeAndPrintResult();
    }
}