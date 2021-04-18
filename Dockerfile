FROM openjdk:11-jdk-alpine

EXPOSE 8080

ADD target/gjg.jar gjg.jar

ENTRYPOINT["java","-jar","/gjg.jar"]