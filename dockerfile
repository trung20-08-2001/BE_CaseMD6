FROM openjdk:8-jdk-alpine
WORKDIR /app

RUN apk update && apk add mysql-client

COPY build/libs/BE-0.0.1-SNAPSHOT.jar BE-0.0.1-SNAPSHOT.jar
COPY src/main/resources/application.properties /app/application.properties

CMD ["java", "-jar", "BE-0.0.1-SNAPSHOT.jar"]