#!/bin/bash

while docker-compose --file docker-compose-test.yml --project-name spring-weather ps -a | grep Exit ; do
  sleep 1s
done
echo "containers built"
while docker-compose --file docker-compose-test.yml --project-name spring-weather ps -a | grep starting ; do
  sleep 1s
done
echo "containers started"
