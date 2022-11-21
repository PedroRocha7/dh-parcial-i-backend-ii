cd eureka-server/
mvn clean && mvn package -DskipTests
docker build . -t eureka-service
cd ..

cd gateway-api/
mvn clean && mvn package -DskipTests
docker build . -t api-gateway
cd ..

cd movies-api/
mvn clean && mvn package -DskipTests
docker build . -t movies-service
cd ..

cd ms-bills/
mvn clean && mvn package -DskipTests
docker build . -t bill-service
cd ..

cd users-service/
mvn clean && mvn package -DskipTests
docker build . -t users-service
cd ..

docker compose up