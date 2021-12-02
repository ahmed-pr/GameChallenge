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

| Endpoint URL  | HTTP protocol type | Description | Inputs |
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



