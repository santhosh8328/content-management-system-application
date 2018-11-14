# 🚧 under construction 🚧

My first application is being developed; at this point, I have learned the Spring concepts, and I am at least ready to put them into practice. the Spring dependencies to create a web application, and I will learn how to put up my first Spring application on IDE (IntelliJ IDEA community) and command line, expose my first endpoint, understand how this works under the hood, and get to know the main annotations of Spring REST support. I will figure out how to create a service layer for the CMS (Content Management System) application and understand how Dependency Injection works in a Spring container. the Spring stereotypes will be met and implement my first Spring bean. At the end of before finishing project, and how to create a view layer and integrate that with Angular or React or Vue or whatever.

The following the list will be worked:

- Creating the project structure
- Running the first Spring application
- Introducing the REST support
- Understanding the Dependency Injection in Spring

## install and run

`mvn clean install spring-boot:run`

navigate to the url:
{get, post, put, delete} http://localhost:8080/category
{get, post, put, delete} http://localhost:8080/user
{get, post, put, delete} http://localhost:8080/news

## Swagger api

`http://localhost:8080/swagger-ui.html`

## setup database under running docker envirnoment

`docker pull postgres:9.6.6:alpine`

`docker pull mongo:latest`

`docker network create cms-application`

`docker run -d --name mongodb --net cms-application --port 27017:27017 mongo:latest`

`docker run -d --name postgres --net cms-application --port 27017:27017 postgres:9.6.6:alpine`

## connect mongo express (admin app for database)

`docker run -d --link mongodb:mongo --net cms-application -p 8081:8081 mongo-express`