FROM openjdk:19-jdk-alpine

EXPOSE 8080

ADD target/authorizationApp-0.0.1-SNAPSHOT.jar myapp.jar