# Use an official OpenJDK runtime as a parent image
FROM openjdk:15-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY target/GraphQLWithSpringBootJpa-0.0.1-SNAPSHOT.jar /app/GraphQLWithSpringBootJpa-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application when the container launches
CMD ["java", "-jar", "GraphQLWithSpringBootJpa-0.0.1-SNAPSHOT.jar"]