# swapi-app
Spring Boot project integrating Star Wars API (SWAPI)

## Requirements
- **Java 8**
- **Maven**
## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/Melanietorales/swapi-app.git
   ```

2. Install dependencies:

   ```bash
   mvn install
   ```

## Running the Application

To start the application:

```bash
mvn spring-boot:run
```

The app will be available at [http://localhost:8080](http://localhost:8080).

### Swagger

To access the interactive API documentation, go to:

```
http://localhost:8080/swagger-ui/
```

## Endpoints

- **GET /films**: Get a list of films.
- **GET /films/{id}**: Get details of a film by ID.
- **GET /people**: Get a list of people.
- **GET /people/{id}**: Get details of a person by ID.
- **GET /starship**: Get a list of starships.
- **GET /starship/{id}**: Get details of a starship by ID.

## Running Tests

1. Run unit tests:

   ```bash
   mvn test
   ```
