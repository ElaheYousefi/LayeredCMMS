CMMS Maintenance Management System
A simplified backend implementation of a CMMS (Computerized Maintenance Management System) developed using a monolithic layered architecture.
This project demonstrates backend development concepts including authentication and authorization, equipment management, task scheduling, testing, database migration, and containerization using modern Java and Spring Boot technologies.
Features
• User authentication and authorization using JWT
• Equipment management
• Task definition and assignment
• Task scheduling
• Technician observation and final task reporting
• RESTful API design
• Database migration with Flyway
• Dockerized deployment
• API documentation with Swagger/OpenAPI
• Unit tests and integration tests
Technologies Used
• Java
• Spring Boot
• Hibernate / JPA
• PostgreSQL
• Flyway
• JWT Authentication
• Docker
• Swagger / OpenAPI
• JUnit
• Mockito
Architecture
The project is developed using a layered monolithic architecture including:
• Controller Layer
• Service Layer
• Repository Layer
• Entity/Model Layer
The goal of this phase is to build a clean, maintainable, and scalable monolithic backend before evolving toward more advanced architectures.
Testing
The project contains:
Unit Tests
Examples:
• Equipment creation
• Task definition
Integration Tests
Examples:
• User login/authentication
• Technician final observation workflow
API Documentation
Swagger/OpenAPI is used for API documentation.
After running the application, Swagger UI is available at:
http://localhost:8080/swagger-ui.html
or
http://localhost:8080/swagger-ui/index.html
Database Migration
Flyway is used for database versioning and schema migration.
Database: PostgreSQL
Running with Docker
To run the project using Docker:
docker-compose up --build
Or run manually:
docker build -t cmms-project .
docker run -p 8080:8080 cmms-project
Future Roadmap
Phase 1
• Monolithic layered architecture
• JWT security
• Testing
• Dockerization
• Flyway migration
Phase 2
• CI/CD pipeline integration
Phase 3
• Event-driven architecture
Phase 4
• Microservices architecture
Phase 5
• Cloud deployment and cloud API integration
Author
Elahe Yousefi
Software Engineer | Backend Developer | CMMS System Developer

