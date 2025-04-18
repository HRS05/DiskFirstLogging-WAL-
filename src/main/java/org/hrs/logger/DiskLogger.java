package org.hrs.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.Instant;
import java.util.concurrent.locks.ReentrantLock;

public class DiskLogger {
    private static final String LOG_DIR = "logs/";
    private static final long MAX_FILE_SIZE = 1024 * 1024; // 1 MB
    private static final ReentrantLock lock = new ReentrantLock();
    private static File currentLogFile = new File(LOG_DIR + "app-0.log");
    private static int fileIndex = 0;

    static {
        File dir = new File(LOG_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static void log(String message) {
        lock.lock();
        try {
            rotateIfNeeded();
            String logEntry = Instant.now() + " | " + message + "\n";
            try (FileWriter writer = new FileWriter(currentLogFile, true)) {
                writer.write(logEntry);
            }
            System.out.println("Logged: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void rotateIfNeeded() {
        if (currentLogFile.length() >= MAX_FILE_SIZE) {
            fileIndex++;
            currentLogFile = new File(LOG_DIR + "app-" + fileIndex + ".log");
        }
    }

    public static String getLogDir() {
        return LOG_DIR;
    }
}
