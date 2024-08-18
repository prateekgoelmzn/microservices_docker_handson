# Stage 1: Build
FROM gradle:jdk17 AS build

# Set the working directory
WORKDIR /app

# Copy Gradle wrapper and build scripts
COPY gradle gradle
COPY settings.gradle .
COPY build.gradle .
COPY gradlew .

# Copy source code
COPY src src

# Build the application
RUN ./gradlew clean build

# Stage 2: Runtime
FROM amazoncorretto:17.0.12-alpine3.20

# Set the working directory
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/build/libs/employee-query-service-0.0.1-SNAPSHOT.jar /app/employee-query-service.jar

# Expose the port your app runs on (if applicable)
EXPOSE 8084

# Command to run the JAR file
CMD ["java", "-jar", "employee-query-service.jar"]
