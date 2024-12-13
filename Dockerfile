FROM openjdk:17-jdk-slim
WORKDIR /book-mgmt-app
COPY app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]