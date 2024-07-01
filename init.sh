#!/bin/bash

echo "Instalando Java 17."
sudo apt update
sudo apt upgrade
sudo apt install openjdk-17-jre-headless

if [ $? -ne 0 ]; then
    echo "Erro ao executar instalar Java 17. Script abortado."
    exit 1
fi

echo "Gerando .jar."
mvn clean package

if [ $? -ne 0 ]; then
    echo "Erro ao executar mvn clean package. Script abortado."
    exit 1
fi

echo "Subindo os containers"
docker-compose down -v
docker-compose up --build

if [ $? -ne 0 ]; then
    echo "Erro ao executar docker-compose up --build. Script abortado."
    sudo apt install docker-compose
    docker-compose up --build
    if [ $? -ne 0 ]; then
      docker-compose down -v
      exit 1
    fi
fi

echo "Script concluído com sucesso."
