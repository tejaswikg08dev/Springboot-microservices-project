# Spring Boot Microservices Application

This project consists of two Spring Boot microservices: User Service and Journal Service. The User Service handles user management, while the Journal Service logs user events. Kafka is used for event communication between the services.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Kafka
- Kafka
- Docker
- Docker Compose
- H2 Database (for testing)

## Prerequisites

- Java 17
- Maven
- Docker and Docker Compose

## Setup

### Step 1: Clone the Repository
Clone the repository to your local machine:

git clone https://github.com/tejaswikg08dev/Springboot-microservices-project.git

### Step 2: Build the Project
Build the project using Maven to download all dependencies and compile the code:

mvn clean install package

### Build Docker Images
Navigate to the directory containing the Dockerfile for each service and build the Docker images:

## For User Service:
- cd user-service
- docker build -t user-service:latest .

## For Journal Service:
- cd journal-service
- docker build -t journal-service:latest .

### Running the Application
### Step 3: Start Kafka and Zookeeper
Start the Kafka and Zookeeper services using Docker Compose:

docker-compose up --build
### Step 4: Access the Services
Once the services are up and running, you can access them via the following URLs:

- User Service: http://localhost:8085
- Journal Service: http://localhost:8086

### API Documentation
The API documentation is available via Swagger UI:

### Step 5: Access Swagger UI
- User Service: http://localhost:8085/swagger-ui.html
- Journal Service: http://localhost:8086/swagger-ui.html
## User Service Endpoints

- POST /users: Create a new user.
- GET /users/{id}: Retrieve a user by ID.
- PUT /users/{id}: Update a user by ID.
- DELETE /users/{id}: Delete a user by ID.
## Journal Service Endpoints

- GET /journals: Retrieve all journal entries.
