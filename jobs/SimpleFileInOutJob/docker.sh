#!/bin/bash

docker run -d --rm --name dummy -v csv:/root alpine tail -f /dev/null
docker cp mnt/inputFile.csv dummy:/root
docker stop dummy
docker build -t nexus.edo.globe.com.ph/repository/edo-aim-dev-docker/talend .
docker push nexus.edo.globe.com.ph/repository/edo-aim-dev-docker/talend
docker run -v csv:/mnt nexus.edo.globe.com.ph/repository/edo-aim-dev-docker/talend
