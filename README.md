# swapi-app
Spring Boot project integrating Star Wars API (SWAPI)

## Requirements
- **Java 8**
- **Maven**
- **Docker** (Optional, if you want to run the app in a container)
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

With docker:

```bash
docker build -t swapi-app .
```

Run the Docker container:

```bash
docker run -p 8080:8080 swapi-app
```

The app will be available at [http://localhost:8080](http://localhost:8080).

## Authentication JWT
This application uses JWT (JSON Web Token) for authentication. To access protected endpoints, you need to include a valid JWT token in the Authorization header as follows:
Authorization: <jwt-token>

### Swagger

To access the interactive API documentation, go to:

```
http://localhost:8080/swagger-ui/
```

## Endpoints

- **GET /swapi/login**: Get session token for authorization.
- **GET /films**: Get a list of films.
- **GET /films/{id}**: Get details of a film by ID.
- **GET /people**: Get a list of people.
- **GET /people/{id}**: Get details of a person by ID.
- **GET /starship**: Get a list of starships.
- **GET /starship/{id}**: Get details of a starship by ID.
- **GET /vehicles**: Get a list of vehicles.
- **GET /vehicles/{id}**: Get details of a vehicle by ID.

## Running Tests

1. Run unit tests:

   ```bash
   mvn test
   ```
