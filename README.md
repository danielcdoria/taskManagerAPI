# Task Manager API

A RESTful API for managing projects and tasks, built with Java and Spring Boot.

## Technologies

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Docker

## Getting Started

### Prerequisites

- Java 17+
- Docker Desktop

### Running the project

**1. Clone the repository**
```bash
git clone https://github.com/your-username/taskManagerAPI.git
cd taskManagerAPI
```

**2. Start the database**
```bash
docker compose up -d
```

**3. Run the application**

Open the project in IntelliJ IDEA and run `TaskManagerApiApplication.java`, or use Maven:
```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

---

## API Endpoints

### Projects

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/projects` | List all projects |
| POST | `/projects` | Create a new project |
| GET | `/projects/{id}` | Get project by ID |
| GET | `/projects/{id}/details` | Get project with its tasks |
| PUT | `/projects/{id}/activate` | Activate a project |
| PUT | `/projects/{id}/deactivate` | Deactivate a project |
| DELETE | `/projects/{id}` | Remove a project |

**Create project — request body:**
```json
{
  "name": "My Project",
  "description": "Project description",
  "deadline": "2025-12-31"
}
```

---

### Tasks

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/tasks` | List all tasks |
| POST | `/tasks` | Create a new task |
| GET | `/tasks/{id}` | Get task by ID |
| PUT | `/tasks/{id}/activate` | Activate a task |
| PUT | `/tasks/{id}/deactivate` | Deactivate a task |
| DELETE | `/tasks/{id}` | Remove a task |
| PUT | `/tasks/{id}/start` | Start a task (TODO → IN_PROGRESS) |
| PUT | `/tasks/{id}/complete` | Complete a task (IN_PROGRESS → DONE) |
| GET | `/tasks/project/{id}` | List tasks by project |
| GET | `/tasks/active?active=true` | Filter by active status |
| GET | `/tasks/status?status=TODO` | Filter by status |
| GET | `/tasks/priority?priority=HIGH` | Filter by priority |
| GET | `/tasks/deadline?deadline=2025-12-31` | Filter by deadline |

**Create task — request body:**
```json
{
  "title": "Implement login",
  "description": "Create JWT authentication",
  "priority": "HIGH",
  "projectId": 1
}
```

---

## Business Rules

- A task can only be created for an **active project**
- Task status follows a strict flow: `PENDING → IN_PROGRESS → DONE`
- A task can only be started if its status is `PENDING`
- A task can only be completed if its status is `IN_PROGRESS`

---

## Project Structure

```
src/
└── main/
    └── java/
        └── com/example/taskManagerAPI/
            ├── controllers/     # REST endpoints
            ├── services/        # Business logic
            ├── repositories/    # Database access
            ├── models/          # Entities (Project, Task)
            ├── dtos/            # Data Transfer Objects
            └── erro/            # Global exception handling
```
