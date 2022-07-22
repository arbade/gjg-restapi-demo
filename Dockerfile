FROM adoptopenjdk/openjdk11:latest

EXPOSE 8080

#ADD target/gjg.jar gjg.jar
COPY target/gjg.jar /usr/local/bin/gjg.jar
RUN chmod +x /usr/local/bin/gjg.jar
CMD ["java", "-jar", "/usr/local/bin/gjg.jar"] 

#ENTRYPOINT ["java","-jar","/gjg.jar"]
