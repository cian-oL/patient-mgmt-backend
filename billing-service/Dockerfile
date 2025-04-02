# build package .jar
FROM maven:3.8.4-openjdk-17-slim AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package

# run
FROM openjdk:17-jdk-slim AS runner

WORKDIR /app

COPY --from=builder /app/target/billing-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4002
EXPOSE 5002

ENTRYPOINT ["java", "-jar", "app.jar"]