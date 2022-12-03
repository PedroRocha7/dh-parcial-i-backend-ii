FROM adoptopenjdk/openjdk11
EXPOSE 8761
ADD /target/movies-service-0.0.1-SNAPSHOT.jar movies-service
COPY target/movies-service-0.0.1-SNAPSHOT.jar movies-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","movies-service-0.0.1-SNAPSHOT.jar"]