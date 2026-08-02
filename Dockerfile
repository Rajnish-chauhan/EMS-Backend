# ==========================================
# Stage 1: Build the Application
# ==========================================
# Using Alpine for the build stage to keep the build process lightweight
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Step 1: Copy ONLY the pom.xml first
COPY pom.xml .

# Step 2: Download dependencies offline.
# Render caches this layer, making your future deployments significantly faster.
RUN mvn dependency:go-offline

# Step 3: Copy source code and package the .jar
COPY src ./src
RUN mvn clean package -DskipTests

# ==========================================
# Stage 2: Run the Application (Ultra-Light)
# ==========================================
# JRE (Not JDK) on Alpine is the smallest possible Java 21 runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built jar from Stage 1
COPY --from=build /app/target/*.jar app.jar


EXPOSE 8080

# ==========================================
# CRITICAL: Render Free Tier Memory Limits
# ==========================================
# -Xmx300m: Prevents the app from using more than 300MB of Heap RAM (keeps you safely under the 512MB limit)
# -Xms150m: Starts the app with 150MB of RAM
# -XX:+UseSerialGC: Switches to the Serial Garbage Collector, which uses vastly less background memory than the default G1GC
ENTRYPOINT ["java", "-Xmx300m", "-Xms150m", "-XX:+UseSerialGC", "-jar", "app.jar"]