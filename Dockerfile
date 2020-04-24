FROM openjdk:13-jdk-alpine
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD webservice/target/webservice-1.0-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]

