FROM ubuntu:latest As build

RUN apt-get update
RUN apt-get install openjdk-24-jdk -y
COPY . .


RUN apt-get install maven -y
RUN mvn clean install



FROM openjdk:24-slim

EXPOSE 8080


COPY --from=build /target/synaptech-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar" ]
