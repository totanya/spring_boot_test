FROM openjdk:8-alpine
ADD target/java-api-0.0.1-SNAPSHOT.jar java-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","java-api.jar"]