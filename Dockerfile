FROM maven:3.6.3-openjdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn clean install

FROM openjdk:11-slim
COPY --from=build /workspace/target/gjg.jar gjg.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","gjg.jar"]

# inital commit


#FROM adoptopenjdk/openjdk11:latest

#EXPOSE 8080

#ADD target/gjg.jar gjg.jar
#COPY --from=build /workspace/target/gjg.jar app.jar
#ENTRYPOINT ["java","-jar","/gjg.jar"]

