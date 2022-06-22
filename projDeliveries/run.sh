cd backend
./mvnw clean install -Dmaven.test.skip

cd ..
docker-compose up -d --build
