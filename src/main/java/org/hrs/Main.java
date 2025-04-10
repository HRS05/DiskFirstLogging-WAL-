package org.hrs;

import org.hrs.logger.DiskLogger;
import org.hrs.process.LogProcessor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DiskLogger.log("User login: harsh123");
        DiskLogger.log("User clicked: /home");
        DiskLogger.log("User login: harsh123");


        String logFile = DiskLogger.getLogFilePath();

        Thread processorThread = new Thread(new LogProcessor(logFile));
        processorThread.start();
    }
}