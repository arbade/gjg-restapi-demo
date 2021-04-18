FROM openjdk:11-jdk-alpine

RUN sudo su

EXPOSE 8080

ADD target/gjg.jar gjg.jar

ENTRYPOINT["java","-jar","/gjg.jar"]