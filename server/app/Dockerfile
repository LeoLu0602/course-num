# Use an official OpenJDK runtime as a parent image.
FROM eclipse-temurin:23-jdk

# Set the working directory inside the container.
WORKDIR /app

# Install Maven (or other build tools if needed).
RUN apt-get update && apt-get install -y maven

# Copy the source code into the container.
COPY server/app /app

# Build the project inside the container.
RUN mvn clean install -DskipTests

# Copy the JAR file into the container.
COPY server/app/target/*.jar app.jar

# Expose the application's port. (Render sets the PORT environment variable)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
