# First stage: build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

COPY app/pom.xml .
COPY app/src ./src

RUN mvn clean package -DskipTests

# Second stage: run
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
