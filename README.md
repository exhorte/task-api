# Task API Project

This project is a **Spring Boot REST API** designed to manage tasks. It is built with a modular architecture, where core business logic (entities, services, and repositories) is encapsulated in a separate `task-core` library.

## Project Purpose

The primary purpose of this project is to provide a robust and scalable API for task management, allowing for the creation, listing, updating of statuses, and counting of tasks.

## Key Features

*   **Task Management:** API endpoints for CRUD (Create, Read, Update) operations on tasks.
*   **Status Updates:** Ability to modify the status of individual tasks.
*   **Task Analytics:** Endpoint to count completed tasks.

## Tech Stack

*   **Java 17:** The primary programming language.
*   **Spring Boot 4.0.3:** Framework for building the RESTful API and managing dependencies.
*   **Spring Data JPA:** For simplified data access and persistence with relational databases.
*   **MySQL:** The relational database used for storing task information.
*   **Lombok:** A library to reduce boilerplate code (e.g., getters, setters, constructors).
*   **Maven:** Build automation tool for Java projects.
*   **Docker:** For containerization and easy deployment of the application.

## Architecture Highlights

*   **API Layer (`sn.isi.l3gl.api`):** Contains the `TaskController` responsible for exposing REST endpoints.
*   **Core Dependency (`sn.isi.l3gl.core:task-core`):** A separate module housing the core business logic, including `Task` entities, `TaskService`, and `TaskRepository`. This dependency is resolved from a local Nexus repository.

## Setup and Run

### Prerequisites

*   Java 17
*   Maven
*   MySQL Server (running on `localhost:3306` with a database named `taskdb`)
*   A local Nexus repository (running on `localhost:8081`) hosting `sn.isi.l3gl.core:task-core:0.3.0`.

### Database Configuration

The application connects to a MySQL database. Ensure your `application.properties` (located in `src/main/resources`) has the correct database connection details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
```

### Building the Project

To build the project, navigate to the project root and run:

```bash
mvn clean install
```

This command will compile the code, run tests, and package the application into a JAR file.

### Running the Application

After building, you can run the application using Spring Boot Maven plugin:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8085`.

### Docker

To build and run the Docker image:

```bash
docker build -t task-api .
docker run -p 8085:8085 task-api
```

## API Endpoints

The `TaskController` exposes the following endpoints:

*   `POST /api/tasks`: Create a new task.
*   `GET /api/tasks`: List all tasks.
*   `PUT /api/tasks/{id}/status`: Update the status of a task by ID.
*   `GET /api/tasks/done/count`: Get the count of completed tasks.

---

**Note:** This project has identified compilation issues related to the `task-core` dependency and JPA entity scanning. These issues need to be resolved for the application to function correctly.
