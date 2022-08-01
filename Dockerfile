FROM openjdk:8-jdk-alpine
COPY target/Facepaint.jar  Facepaint.jar
ENTRYPOINT ["java", "-jar", "/Facepaint.jar"]