FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} genesis.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/genesis.jar"]