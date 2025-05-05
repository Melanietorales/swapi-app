FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY target/swapi-app-0.0.1-SNAPSHOT.jar /app/swapi-app.jar

EXPOSE 8080

CMD ["java", "-jar", "swapi-app.jar"]
