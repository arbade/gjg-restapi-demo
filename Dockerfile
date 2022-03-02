FROM adoptopenjdk/openjdk11:latest

EXPOSE 8080

ADD target/gjg.jar gjg.jar

#revertToChanges
#newPointAdded
ENTRYPOINT ["java","-jar","/gjg.jar"]
