# FROM maven:3.8.2-jdk-8 # for Java 8
FROM openjdk:17-jdk-alpine

WORKDIR /app

VOLUME /tmp

ADD nmc-file-storage-service-0.0.1-SNAPSHOT.jar nmc-file-storage-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "nmc-file-storage-service-0.0.1-SNAPSHOT.jar"]