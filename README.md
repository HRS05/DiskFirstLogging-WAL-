# Disk-Based Queue System (Kafka-Style)

This project is a lightweight, disk-backed message queue system implemented in Java. It simulates key features of systems like Apache Kafka by using **write-ahead log (WAL)** files for durability, file rotation for scalability, and a simple **producer-consumer** model.

---

## 📁 Project Structure

└── Main.java  
├── logger/  │ └── DiskLogger.java  
├── process/ │ └── LogProcessor.java  
├── queue/ │ ├── QueueProducer.java   
             └── QueueConsumer.java   

---

## 🔧 Features

- ✅ **Write-Ahead Logging**: All messages are immediately written to disk.
- ✅ **Log File Rotation**: Automatically rotates log files after 1 MB.
- ✅ **Producer/Consumer Decoupling**: Safe concurrent writing/reading.
- ✅ **Offset Management**: Keeps track of where the consumer left off.
- 🚀 **Pluggable System**: Easily extend to add acknowledgments, topics, partitions, etc.


