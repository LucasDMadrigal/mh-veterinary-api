FROM gradle:8-jdk17-alpine

COPY src/main/java/com/veterinary/veterinaryApp .

RUN gradle build

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/app-0.0.1-SNAPSHOT.jar"]