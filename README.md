# Adidas Challenge

## Introduction

This challenge defines a simple cloud scenario using Spring Cloud. We want to create a service that given an origin city will return a list of itineraries , one based in the less number of connections and the second based in the less time.
The elements of this scenario are the following:

- H2: A simple SQL database embedded used data-service microservice to obtain the data travels.
- Registry-Service: Discovery and Registry server. Each instance of each microservice will register itself on this server.
- Data-Service: Microservice that exposes endpoints to obtain the data present on H2.
- Business-Logic-Service: Microservice that exposes endpoints to calculate the sort way in time and in connections

## Technology

The base stack is the following:
- Java8
- Spring Boot 2.0.1
- Spring Cloud Finchley.RC2
- H2 Data Base
- Docker
- Maven

## How it works

Execute docker-compose.yml:

	docker-compose up
	
### Registry-Service (Eureka)

	http://localhost:8761/

### Data Base (H2)

user: adidas
pass: adidas

	http://localhost:8002/h2

### Rest Service

- Get all possible destinations in a city (Zaragoza, London, Berlin): /api/travel/{city}

	http://localhost:8002/api/travel/Berlin 
- Calculate by time: /api/calculate/bytime?city={city}&destinyCity={destinyCity}. Example

	http://localhost:8003/api/calculate/bytime?city=Zaragoza&destinyCity=Berlin	
- Calculate by connection: http://localhost:8003/api/calculate/byconnection?city={city}&destinyCity={destinyCity}. Example

	http://localhost:8003/api/calculate/byconnection?city=Zaragoza&destinyCity=Milan
