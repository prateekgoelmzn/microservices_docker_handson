# Use the official maven image
FROM maven:3.9.8-amazoncorretto-17-al2023
# Set the working directory
WORKDIR /app
# Copy pom.xml file
COPY pom.xml .
# Copy src directory
COPY src ./src
# Run maven command to clean old build jar and create new
RUN mvn clean package
# Use the official OpenJDK base image
FROM amazoncorretto:17.0.12-alpine3.20
# Set the working directory
WORKDIR /app
# Copy the jar file into the container
COPY --from=0 /app/target/employee-cache-service-0.0.1-SNAPSHOT.jar /app/employee-cache-service.jar
# Expose the port that your application runs on
EXPOSE 8082
# Command to run the jar file
CMD ["java", "-jar", "employee-cache-service.jar"]