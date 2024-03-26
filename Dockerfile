#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY --from=build ./target/push-notification-0.0.1-SNAPSHOT.jar demo.jar

# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]