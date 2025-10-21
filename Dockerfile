## Build stage
#FROM maven:3.9.6-eclipse-temurin-17 AS build
#WORKDIR /app
#
#COPY app/pom.xml .
#COPY app/src ./src
#RUN mvn clean package -DskipTests
#
## Runtime stage
#FROM eclipse-temurin:17-jdk-alpine
#WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]
# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy the parent POM first (if any) and module POM
COPY pom.xml ./
COPY app/pom.xml ./app/
COPY app/src ./app/src

# Build the project
RUN mvn -f ./app/pom.xml clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the JAR from build stage
COPY --from=build /app/app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
