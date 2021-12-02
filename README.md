# GameChallenge

This project is an attempt to simulate a game management Backend service.
The main objective of this project was to create a simple API to manage games (CRUD). This API should allow to:
* Create and challenge 2 or more players (by username) to a new game;
* Mark the outcome of a game (ranking);
* Surrender from a game;
* Get game by id;
* List places and filter them by name, player(s) or date created

## Technology stack
* Spring Boot.
* Hibernate JPA.
* REST API (JSON).
* MySQL DBMS.
* cURL.
* Docker.


## Endpoints
Our applications provide multiple endpoints so that other clients can easily communicate with it :

| Endpoint URL  | HTTP protocol | Description | Inputs |
| ------------- | ---------------------- | -------- | ------ |
| gameById | GET  | Return Game object by using his game_id | id |
| createGame | POST | Create a new Game record in DB by using a game_type  | game_type |
| createPlayer | POST | Create a new Player record in DB by using a username | username |
| challengePlayer | PUT | Challenge a player to participate in a game | id_game, username |
| acceptChallenge | PUT | Player agrees to participate in a specific game which has been invited to | id_game, username |
| startGame | PUT | Launch a specific game | id_game |
| surrenderFromGame | PUT | Surrender from a specific game | id_game, username |
| updatePlayerRanking | PUT | Update raking of a specific player which is involved in a game | id_game, username | 
| finishGame | PUT | Finish a specific game | id_game |
| getGamesInfos | GET | Listing existing games and optionnaly filtring them by by name, player(s) or date created. | (Optional) name, player, createdAt |



## Running source code in an IDE
In order to run the source code you only have to copy the content of this repository to your favorite Spring IDE (Eclipse, IntelliJ IDEA...). After that, you will have to specify your own database properties in application.properties file so that you can successfuly run the application. You can test your API using cURL or POSTMAN...



## Running application in Docker
You need to have Docker and Docker Compose installation in your computer (if your are using Docker Desktop, Docker Compose is already included in this Docker version).
To run this application using Docker, please follow this steps :
* First you have to generate the application .jar file by running the following command in your IDE or in command line :  mvn clean package. (.jar file will be in target directory of your project).
* Move this two files : Dockerfile and docker-compose.yml to target directory.
* Open a command line interface and access to the target directory.
* After that run the following command to launch our containers : docker-compose up -d
*  If Docker Compose runned successfuly. Run the following to get containers names : docker ps -a (in general MySQL container will have the following name : target_bd_1 and Spring container will have the following name : target_spring_1)

* MySQL by default does not allow remote connection, to modify this behavor you will have to run this following commands by order : 
* * docker container exec -it target_bd_1 /bin/bash
* * mysql
* * use mysql;
* * CREATE USER 'root'@'%' IDENTIFIED BY 'dockpass';
* * GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
* * exit (quitting MySQL command line interface)
* * exit (quitting Linux command line shell)

* After getting back to our OS machine CLI we will have to restart Spring container by using his name so that we can finally run our application : restart target_spring_1

