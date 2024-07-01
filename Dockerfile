FROM openjdk:17-jdk-slim

WORKDIR /app
COPY target/*.jar se-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "se-0.0.1-SNAPSHOT.jar"]
