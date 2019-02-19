docker-tomcat-sample

dockerfile and docker-compose file to run tomcat application

JRE 8, JDK8, Tomcat 8.0.47, Ubuntu 14.04

-Steps to run

1. build docker image using Dockerfile (Replace Maintainer in the file to your name-email)
  - docker build -f Dockerfile . 
2. list docker images and find image_id for the image you just built
   - docker images 
3. reate a repository on docker hub
   - tag the image using
4. docker tag <image_id> username/reponame 
   - push the docker image (if you are not logged in, run docker login first
5. docker push 
6. I have created a docker-compose.yml file.
   - Start and serve the docker container using
7. docker-compose up


Notes

-To run this you need docker installed on your system and drive share enabled.
-You need an acocunt on docker hub.
-To run your code replace the folders WEB-INF and META-INF and files index.html and home.jsp