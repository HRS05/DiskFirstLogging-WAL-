package org.hrs.consumer;
import org.hrs.process.LogProcessor;

public class Consumer {
    private final String logDir;

    public Consumer(String logDir) {
        this.logDir = logDir;
    }

    public void start() {
        Thread processorThread = new Thread(new LogProcessor(logDir));
        processorThread.start();
    }
}
