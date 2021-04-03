# Getting Started

## Prerequisites

- maven, mysql8, jdk 11
- create a database utf8mb4 encoded
- edit database properties in src\main\resources\application.properties

## Running the app

Use either :

<code>
mvn clean package
</code>

Then

<code>
java -jar target/api-skeleton-0.0.1-SNAPSHOT.jar
</code>

Or

<code>
mvnw spring-boot:run
</code>

## Swagger UI / Openapi spec pages

- Openapi : http://localhost:8080//api/openapi
- Swagger UI : http://localhost:8080/swagger-ui.html

### Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/#build-image)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)
- [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)

### Guides

The following guides illustrate how to use some features concretely:

- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
- [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
- [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
- [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
