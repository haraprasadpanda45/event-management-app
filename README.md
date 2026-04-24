# event-management-app
Architecture Overview

This application follows a layered Model–View–Controller (MVC) architecture to ensure separation of concerns, maintainability, and scalability.

Architecture Flow
User (Browser)
   ↓
Controller Layer
   ↓
Service Layer
   ↓
Repository Layer
   ↓
Database (H2)
How It Works
Client Layer (Browser)
The user interacts with the application through web pages rendered using Thymeleaf.
Controller Layer
Handles incoming HTTP requests and maps them to appropriate handler methods using Spring MVC annotations. It also prepares data for the view layer.
Service Layer
Contains business logic such as event creation, retrieval, and registration handling. It ensures application rules are enforced (e.g., avoiding duplicate registrations).
Repository Layer
Uses Spring Data JPA to perform database operations such as create, read, update, and delete.
Database Layer
An H2 in-memory database is used to store event and registration data during runtime.
View Layer (Thymeleaf)
Responsible for rendering dynamic HTML pages and displaying data to the user.
Request Flow Example

Event Registration Process:

The user submits the registration form.
The controller receives the POST request.
The service layer processes the registration logic.
The repository persists the data.
The application redirects the user to the homepage.
Updated event data is displayed.
Technology Stack
Java 17
Spring Boot
Spring MVC
Spring Data JPA
Thymeleaf
H2 Database
Gradle
