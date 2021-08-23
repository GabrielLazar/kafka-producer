# Kafka Producer

Use the Java producer API to publish records to Kafka.

# Prerequisites
You will need to following tools in order to work with this project and code

* git (http://git-scm.com/)
* JDK 1.8+ (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Maven 3.x+ (http://maven.apache.org/)
* Apache Kafka (https://kafka.apache.org/downloads)
* An IDE of your choice. (Eclipse, IntelliJ, Spring STS)

# Getting Started
To run this project locally, perform the following steps.
1. Clone project to your machine using git - "git clone https://github.com/GabrielLazar/kafka-producer.git" 
2. Import the project to IDE
3. Run Spring-boot project
4. Start zookeeper server: 
        "zookeeper-server-start.bat config\zookeeper.properties"
6. Start kafka server: 
        "kafka-server-start.bat config\server.properties"
8. Create topic:
        "kafka-topics --bootstrap-server localhost:9092 --topic employees --create --partitions 4 --replication-factor 1"
10. Trigger endpoint to send data:
        "http://localhost:8080/employees"
12. Create consumer to subscribe to topic and get the data:
        "kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic employees --from-beginning"

Created by @Gabriel Lazar Halitchi
