# Step 1: Use an official base image (OpenJDK 17) 

#for x86_64 architecture 

FROM eclipse-temurin:17-jdk 

 

#for ARM64 architecture 

#FROM --platform=linux/arm64 eclipse-temurin:17-jdk 

 

# Step 2: Copy your JAR file into the container 

COPY target/*.jar app.jar 

 

# Step 3: Expose the port your app runs on 

EXPOSE 8081

 

# Step 4: Run the application 

CMD ["java", "-jar", "/app.jar"] 
