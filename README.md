# 🚀 Disk-First Logging in Java

> **Java + Disk-First Logging = Bulletproof Observability**

## 🧠 Overview

In performance-critical applications, logging to memory or remote systems can introduce latency or risk log loss on crashes.  
This mini-project demonstrates a **Disk-First Logging Architecture** where:

- Logs are **written to disk first** for durability.
- A **background thread** reads logs from the file and sends them to a **mock external system** (stdout).

---

## ⚙️ Features

✅ Durable disk-based logging  
✅ Async log processing  
✅ Crash-safe architecture  
✅ Ideal for microservices and distributed systems

---


---

## 🧪 How It Works

1. The `DiskLogger` class writes log entries to a file (`logs/app.log`).
2. `LogProcessor` runs in a background thread and reads entries line-by-line.
3. Each log is "processed" by printing it to the console (simulating external sync).
4. This keeps your app responsive and logs durable.

---

## 🛠️ How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/HRS05/DiskFirstLogging-WAL-.git
   cd DiskFirstLogging


