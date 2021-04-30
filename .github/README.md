# Spring Boot Restful service project

This is a sample Java / Maven / Spring Boot application.

## How to Run
###Maven 
* Clone this repository
* Make sure you have installed PostgreSQL
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
    mvn spring-boot:run
```
### Using Docker
* Make sure you have installed Docker
* Checkout this repository
```
    docker-compose build
    docker-compose up
```

## About the Service

The service is just a simple account REST service. 
It uses a PostgreSql database to store the data. 

Here are some endpoints you can call:

### Create account resource

```
POST /api/v1/accounts
Accept: application/json
Content-Type: application/json

{
"id" : 1
"name" : "Generic Name",
"phone" : "999999999",
"email" : "genericname@company.com",
"address" : "Generic Street 42 Earth",
"country" : "Navarro",
"department" : "T21R",
}

RESPONSE: HTTP 201 (Created)
```

### Retrieve a list of accounts
```
GET /api/v1/accounts

Response: HTTP 200
Content: list 
```

### Update a hotel resource

```
PUT /api/v1/accounts/1
Accept: application/json
Content-Type: application/json

{
"id" : 1
"name" : "Generic Name",
"phone" : "999999999",
"email" : "genericname@company.com",
"address" : "Generic Street 42 Earth",
"country" : "Navarro",
"department" : "T21R",
}

RESPONSE: HTTP 200 
```

### Delete a hotel resource

```
DELETE /api/v1/accounts/1
Accept: application/json
Content-Type: application/json



RESPONSE: HTTP 204 (NO CONTENT)
```



