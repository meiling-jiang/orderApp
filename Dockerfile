FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/oms-backend.jar oms-backend.jar
EXPOSE 8080
CMD ["java","-jar","oms-backend.jar"]