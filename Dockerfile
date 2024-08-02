# Use an official Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/task-management-0.0.1-SNAPSHOT.jar /app/task-management.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/task-management.jar"]
