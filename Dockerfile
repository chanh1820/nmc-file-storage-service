# FROM maven:3.8.2-jdk-8 # for Java 8
FROM openjdk:17-jdk-alpine

WORKDIR /app

VOLUME /tmp

ADD backend-forum-0.0.1-SNAPSHOT.jar backend-forum-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "backend-forum-0.0.1-SNAPSHOT.jar"]