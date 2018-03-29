#!/bin/bash

cd /home/earthchen/study/elasictsearch/docker-start
docker-compose start

docker start mysql
docker start redis
docker start myrabbitmq
