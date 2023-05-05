FROM amazoncorretto:8

MAINTAINER CandelaAlv
COPY target/candelaport-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]