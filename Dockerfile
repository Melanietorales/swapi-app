FROM maven:3.8.5-openjdk-8-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/swapi-app-0.0.1-SNAPSHOT.jar swapi-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "swapi-app.jar"]