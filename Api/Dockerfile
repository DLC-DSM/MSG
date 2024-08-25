
FROM bellsoft/liberica-openjdk-alpine:22
FROM openjdk:21-jdk

LABEL authors="user"
VOLUME /tmp

ARG JAR_FILE=Api/build/libs/Api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

CMD ["./gradlew", "clean", "build"]
ENTRYPOINT ["java","-jar","/app.jar"]