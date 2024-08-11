FROM openjdk:8
EXPOSE 8080
ADD target/redis-github-actions.jar redis-github-actions.jar
ENTRYPOINT ["java", "-jar",  "/redis-github-actions.jar"]
