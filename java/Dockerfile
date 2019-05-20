# Build stage
# Parent image is Maven
FROM maven:latest as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM openjdk:8-jre
COPY --from=build /home/app/target/docker-example-0.0.1-SNAPSHOT.jar /usr/local/lib/docker-example.jar
EXPOSE 8080
CMD ["java","-jar","/usr/local/lib/docker-example.jar"]
