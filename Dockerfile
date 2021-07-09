FROM openjdk:8

EXPOSE 8080

ADD target/gjg.jar gjg.jar

#revertToChanges

ENTRYPOINT ["java","-jar","/gjg.jar"]
