package org.hrs.logger;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class DiskLogger {
    private static final String LOG_FILE = "logs/app.log";

    public static synchronized void log(String message) {
        String logEntry = Instant.now().toString() + " | " + message + "\n";
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logEntry);
            System.out.println("Logged: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLogFilePath() {
        return LOG_FILE;
    }
}
