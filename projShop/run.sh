cd backend/music
./mvnw clean install -Dmaven.test.skip

cd ../../
docker-compose up -d --build
