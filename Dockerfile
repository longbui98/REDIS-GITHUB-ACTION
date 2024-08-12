FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
EXPOSE 8080
WORKDIR /app
COPY --from=build /app/target/redis-github-actions.jar /app/redis-github-actions.jar
ENTRYPOINT ["java", "-jar",  "/redis-github-actions.jar"]
