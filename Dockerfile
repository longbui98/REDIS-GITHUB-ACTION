FROM openjdk:21-jdk-slim
EXPOSE 8080
ADD target/redis-github-actions.jar redis-github-actions.jar
ENTRYPOINT ["java", "-jar",  "/redis-github-actions.jar"]