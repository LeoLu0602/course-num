# Use an official Java runtime as a parent image.
FROM openjdk:17-jdk-slim as builder

# Set the working directory in the container.
WORKDIR /app

# Copy the Maven wrapper and POM files.
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy the source code.
COPY src ./src

# Build the application.
RUN ./mvnw clean package -DskipTests

# Create the final image.
FROM openjdk:17-jdk-slim

# Set the working directory in the container.
WORKDIR /app

# Copy the built jar from the builder stage.
COPY --from=builder /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
