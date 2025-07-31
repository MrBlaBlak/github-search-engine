# GitHub Repo Search Engine

This project is a simple Spring Boot service that exposes an HTTP endpoint for retrieving a GitHub user's public repositories (excluding forks), including each repository's branches and the SHA of the latest commit on each branch.

## 🧰 Tech Stack

- Java 21
- Spring Boot 3.5
- REST API (Spring Web)
- TestRestTemplate + SpringBootTest
- No DDD, no hexagonal architecture (as required)
- Single integration test (as required)

---

## 🔧 Getting Started

1. **Requirements:**
  - Java 21+
  - Maven 3.8+

2. **Run locally:**

```bash
mvn spring-boot:run
```
### Endpoint
```bash
GET /github/{username}
```

### Sample Response
```
json
[
  {
    "repositoryName": "example-repo",
    "userName": "mrblablak",
    "branches": [
      {
        "name": "main",
        "lastCommitSha": "e2f2f6d..."
      }
    ]
  }
]
```

### 404 Error Response (User Not Found)
```
json
{
  "status": 404,
  "message": "User not found"
}
```

## ✅ Tests
This project includes a single integration test, as specified in the task requirements.

### The test verifies:

Each repository includes:

- Repository name
- Owner login
- Branch list with:
- Branch name
- Latest commit SHA

### The task states that mocking should be avoided if possible.

#### Therefore:

We only provide a real HTTP test using TestRestTemplate

Filtering (excluding forks) is not verified directly (mocking required)

### 🧪 Running Tests
```
mvn test
```

## ✍️ Author
This project was developed as a interview test task by Michał Romak.
