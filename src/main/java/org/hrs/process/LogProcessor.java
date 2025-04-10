package org.hrs.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogProcessor implements Runnable {
    private final String logFile;

    public LogProcessor(String logFile) {
        this.logFile = logFile;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Processing log: " + line);
                Thread.sleep(500); // delay for observing
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
