FROM adoptopenjdk/openjdk11:latest

EXPOSE 8080

#ADD target/gjg.jar gjg.jar
COPY --from=build /workspace/target/gjg.jar app.jar
ENTRYPOINT ["java","-jar","/gjg.jar"]

