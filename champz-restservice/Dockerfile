FROM openjdk:8-jdk-alpine
MAINTAINER Kleber Manoel Infante (Corujito) corujito@gmail.com
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
#ENTRYPOINT java -Dmongo.ip=${MONGO_IP} -Djava.security.egd=file:/dev/./urandom -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=y -jar /app.jar
ENTRYPOINT java -Dmongo.ip=${MONGO_IP} -Djava.security.egd=file:/dev/./urandom -jar /app.jar
