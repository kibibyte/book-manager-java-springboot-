# Books management application (Java, Spring Boot)

## Modules

* app
* data
* domain

## Build

```shell script
$ ./gradlew build
```

## Test

```shell script
$ ./gradlew test
```

## Running locally

```shell script
$ ./gradlew bootJar
$ docker compose up
```

Example request:

```shell script
curl --request GET --url http://localhost:8080/books
```
