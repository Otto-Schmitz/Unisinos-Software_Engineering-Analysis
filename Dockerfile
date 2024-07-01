FROM openjdk:17-jdk-slim

WORKDIR /app
COPY target/seu-aplicativo.jar .

CMD ["java", "-jar", "seu-aplicativo.jar"]
