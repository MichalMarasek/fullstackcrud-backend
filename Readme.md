Full stack application with Backend in Java Spring Boot and Frontend in Javascript React framework with MySQL Database.
You can use this project as a base for any other full stack projects.

Spring boot backend is running on port 8080
React frontend is running on port 3000

Docker info:
MySQL Database used with this project was set up using docker image. 
You can follow below steps to set up yours docker image.

To pull docker mysql image use:
docker pull mysql
To start docker mysql container use:
docker run --name booklibrary-mysql -e MYSQL_ROOT_PASSWORD=passw -d -p 3306:3306 mysql

Your database will be exposed on port 3306 on your local system.

To check if docker image started correctly use:
docker ps

In case of any problems you can delete container using:
docker rm --force booklibrary-mysql

To stop your container use:
docker stop <container-id>

or more brutal way:
docker kill <container-id>


To manage database you can use any MySQL compatible client eg. MySQL Workbench
https://dev.mysql.com/downloads/workbench/

Database:

create database booklibrary;
show databases;
use booklibrary;
show tables;

Table will be created automatically once backend project starts.

You can test your API using postman:
https://www.postman.com/downloads/


Sample payload for post operation to add books:
POST Request localhost:8080/book
{
"author":"Dune Author",
"booktitle":"The Dune",
"description":"Book about Dune"
}

GET all books
localhost:8080/books

GET single book by id
localhost:8080/book/{id}

UPDATE single book by id using PUT
localhost:8080/book/{id}

Sample Payload:
{
"author": "Dune Author",
"title": "Dune",
"description": "Book about Dune"
}

DELETE single book by id:
localhost:8080/book/{id}
