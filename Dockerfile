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
# -----------------------------
# Build stage
# -----------------------------
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /workspace

# Copy the parent POM first (to leverage Docker cache)
COPY pom.xml ./

# Copy all modules (required for multi-module Maven build)
COPY app ./app
COPY api ./api
COPY domain ./domain
COPY service ./service
COPY repository ./repository

# Build the entire project without running tests
RUN mvn clean package -DskipTests -f pom.xml

# -----------------------------
# Runtime stage
# -----------------------------
FROM eclipse-temurin:17-jdk-alpine

# Set working directory for runtime
WORKDIR /app

# Copy the built app JAR from build stage
COPY --from=build /workspace/app/target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Start the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

