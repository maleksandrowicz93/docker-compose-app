#!/bin/bash
MODULE_NAME=""

build_app() {
  echo "Creating ${MODULE_NAME} .jar artifact..."
  sleep 3s
  mvn clean package -Dmaven.test.skip=true
  sleep 1s
}

cd springboot-api-docker
MODULE_NAME="springboot-api-docker"
build_app
cd ../springboot-client-docker
MODULE_NAME="springboot-client-docker"
build_app
cd ..
echo "Running application..."
sleep 3s
docker-compose up