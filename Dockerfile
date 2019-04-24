# Get the Maven Alpine Docker image.
FROM maven:3.6.0-jdk-8-alpine AS maven

# Set the working directory.
WORKDIR /app

# Copy over the POM file to the working directory (for caching purposes).
COPY pom.xml ./

# Install the Maven dependencies.
RUN mvn dependency:go-offline -B

# Copy over the application files to the working directory.
COPY ./ ./

# Build the application.
RUN mvn clean package

# Get the Java Alpine Docker image.
FROM openjdk:8-jre-alpine

# Set the working directory.
WORKDIR /app

# Copy the JAR into the image.
COPY --from=maven /app/target/gameframe-gateway.jar ./

# Run the application.
CMD ["java", "-jar", "gameframe-gateway.jar"]