FROM adoptopenjdk/openjdk11
EXPOSE 8761
ADD /target/users-service-0.0.1-SNAPSHOT.jar users-service
COPY target/users-service-0.0.1-SNAPSHOT.jar users-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","users-service-0.0.1-SNAPSHOT.jar"]