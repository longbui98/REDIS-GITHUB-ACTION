FROM openjdk:21-jdk-slim
EXPOSE 8080
ADD target/redis-github-actions.war redis-github-actions.war
ENTRYPOINT ["java", "-jar",  "/redis-github-actions.war"]