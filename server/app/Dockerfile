# Use a base image with OpenJDK
FROM openjdk:23-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR to the container
COPY app.jar app.jar

# Expose the application port (default is 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
