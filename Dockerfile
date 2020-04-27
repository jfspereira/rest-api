FROM openjdk:13-jdk-alpine
VOLUME /tmp
ADD webservice/target/webservice-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app.jar"]

