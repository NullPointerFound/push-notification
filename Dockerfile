FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/push-notification-0.0.1-SNAPSHOT.jar demo.jar

# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]