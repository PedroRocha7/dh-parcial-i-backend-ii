FROM adoptopenjdk/openjdk11
EXPOSE 8761
ADD /target/bill-service-0.0.1-SNAPSHOT.jar bill-service
COPY target/bill-service-0.0.1-SNAPSHOT.jar bill-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","bill-service-0.0.1-SNAPSHOT.jar"]