#
# Build stage
#
#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip

#
# Package stage
#
#FROM openjdk:11-jre-slim
#COPY --from=build /home/app/target/music-0.0.1-SNAPSHOT.jar /usr/local/lib/music.jar
#EXPOSE 7070
#ENTRYPOINT ["java","-jar","/usr/local/lib/music.jar"]

FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

