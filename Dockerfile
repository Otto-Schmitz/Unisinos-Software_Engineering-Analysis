# Use uma imagem com Maven para construir o artefato
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e as dependências para o cache das dependências do Maven
COPY pom.xml .
COPY src ./src

# Execute o comando para construir o .jar
RUN mvn clean package -DskipTests

# Use uma imagem mais leve do OpenJDK para executar o aplicativo
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o .jar do estágio de construção anterior para a imagem final
COPY --from=build /app/target/se-0.0.1-SNAPSHOT.jar se-0.0.1-SNAPSHOT.jar

# Comando para executar o .jar
CMD ["java", "-jar", "se-0.0.1-SNAPSHOT.jar"]
