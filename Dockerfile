FROM openjdk:8

EXPOSE 8080

ADD target/gjg.jar gjg.jar

ENTRYPOINT ["java","-jar","/gjg.jar"]
