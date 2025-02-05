

FROM openjdk:21-jdk-slim AS build

COPY . .

RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build target/Numbers-0.0.1-SNAPSHOT.jar /app/Numbers.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/Numbers.jar"]
