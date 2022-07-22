FROM adoptopenjdk/openjdk11:latest

EXPOSE 8080

ADD target/gjg.jar gjg.jar
#COPY target/gjg.jar ../gjg.jar
ENTRYPOINT ["java","-jar","/gjg.jar"]

C#MD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/gjg.jar"]
