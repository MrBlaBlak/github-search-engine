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


