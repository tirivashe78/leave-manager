# Use Java 17 JDK base image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside container
WORKDIR /app

# Copy the built JAR from target folder to container
COPY target/*.jar app.jar

# Expose Spring Boot’s default port
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java","-jar","/app/app.jar"]
