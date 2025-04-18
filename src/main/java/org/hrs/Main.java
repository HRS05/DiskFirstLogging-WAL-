package org.hrs;

import org.hrs.producer.Producer;
import org.hrs.consumer.Consumer;
import org.hrs.logger.DiskLogger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Queue system started...");

        Producer producer = new Producer();
        Consumer consumer = new Consumer(DiskLogger.getLogDir());

        consumer.start();

        // Simulate producer sending messages
        for (long i = 0; i < 100000000; i++) {
            producer.send("Event #" + i);
            Thread.sleep(100); // simulate delay
        }
    }
}
