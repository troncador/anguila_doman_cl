#!/bin/bash

sudo docker run   \
   -v ~/.program/maven/:/root/.m2 \
   -v code-server/webapp-anguila:/opt/build/   --rm   troncador_tomcat    mvn  -f /opt/build/pom.xml package

