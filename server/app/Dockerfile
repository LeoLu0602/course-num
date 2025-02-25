# Use an official OpenJDK runtime as a parent image.
FROM eclipse-temurin:23-jdk

# Set the working directory inside the container.
WORKDIR /app

# Copy the JAR file into the container.
COPY target/*.jar app.jar

# Expose the application's port. (Render sets the PORT environment variable)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
