FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

FROM openjdk:17-jdk-slim as runtime
FROM maven:3.0.11-openjdk-17 as builder

RUN apt-get update
RUN apt-get install maven -y
RUN mvn clean install

EXPOSE 8080

COPY --from=builder /target/todolist-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
