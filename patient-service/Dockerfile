# specifying a base image to use
FROM maven:3.9.9-eclipse-temurin-21 AS builder

# setting the working directory in the container
WORKDIR /app

# copying all of the dependencies from pom.xml to the root folder of the container which is essentially /app
COPY pom.xml .

# Installing the dependencies that our spring boot app needs in inside the container
RUN mvn dependency:go-offline -B #cache dependencies so that everytime no need to fetch dependencies

COPY src ./src

# Package everything into a jar file(a single jar file is create which contains all of our dependencies)
RUN mvn clean package

#**************************************************************
# Using OpenJDK runtime to run our code(builded app)
FROM openjdk:21-jdk AS runner

WORKDIR /app

# Below cmd copes the patient-service snapshot.jar that was create in the builder step into the runner step(in to the location of root as app.jar)
COPY --from=builder ./app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4000

ENTRYPOINT ["java", "-jar", "app.jar"]