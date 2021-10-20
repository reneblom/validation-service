# Build stage
FROM harbor.cicd.s15m.nl/bzk-koop-docker-hub/library/maven:3.8-openjdk-11 AS build

COPY . .

RUN mvn clean package

#Package stage
FROM harbor.cicd.s15m.nl/bzk-koop-docker-hub/library/adoptopenjdk:11-jre-hotspot
COPY --from=build ./target/plooi-aanlever-api-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080/tcp
EXPOSE 8080/udp
ENTRYPOINT ["java","-jar", "/app.jar"]
