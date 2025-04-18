package org.hrs.process;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class LogProcessor implements Runnable {
    private final String logDir;
    private int fileIndex = 0;
    private long offset = 0;

    public LogProcessor(String logDir) {
        this.logDir = logDir;
    }

    @Override
    public void run() {
        try {
            while (true) {
                File logFile = new File(logDir + "app-" + fileIndex + ".log");
                if (!logFile.exists()) {
                    TimeUnit.MILLISECONDS.sleep(500);
                    continue;
                }

                try (RandomAccessFile reader = new RandomAccessFile(logFile, "r")) {
                    reader.seek(offset);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Processing log: " + line);
                        offset = reader.getFilePointer();
                        TimeUnit.MILLISECONDS.sleep(200); // simulate work
                    }

                    // Rotate to next file if fully read and new file exists
                    if (reader.length() == offset && new File(logDir + "app-" + (fileIndex + 1) + ".log").exists()) {
                        fileIndex++;
                        offset = 0;
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
