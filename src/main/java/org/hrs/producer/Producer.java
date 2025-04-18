package org.hrs.producer;

import org.hrs.logger.DiskLogger;

public class Producer {
    public void send(String message) {
        DiskLogger.log(message);
    }
}
