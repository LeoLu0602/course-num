# Use an official OpenJDK runtime as a parent image.
FROM eclipse-temurin:23-jdk

# Set the working directory inside the container.
WORKDIR /app

# Copy the source code into the container.
COPY . .

# Install Maven (or other build tools if needed).
RUN apt-get update && apt-get install -y maven

# Build the project inside the container.
RUN mvn clean install -DskipTests

# Expose the application's port. (Render sets the PORT environment variable)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
