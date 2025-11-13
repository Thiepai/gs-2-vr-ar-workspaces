FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/gs-2-vr-ar-workspaces-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]