cd eureka-service/
mvn clean && mvn package -DskipTests
docker build . -t eureka-service
cd ..

cd api-gateway/
mvn clean && mvn package -DskipTests
docker build . -t api-gateway
cd ..

cd movies-service/
mvn clean && mvn package -DskipTests
docker build . -t movies-service
cd ..

cd bill-service/
mvn clean && mvn package -DskipTests
docker build . -t bill-service
cd ..

cd users-service/
mvn clean && mvn package -DskipTests
docker build . -t users-service
cd ..

docker compose up