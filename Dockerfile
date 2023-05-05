FROM amazoncorretto:8-alpine-jdk

COPY target/candelaport-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]