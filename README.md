# SustainableWasteManagementAPI

## Overview
**SustainableWasteManagementAPI**The Waste Management and Recycling Tips Application is designed to promote sustainable practices by providing users with detailed information about waste categories and recycling tips. This application helps individuals and organizations understand the best methods for managing waste and encourages the adoption of eco-friendly habits.

The project includes features for managing waste categories and recycling tips, supported by a robust backend system implemented in Java using Spring Boot. It also features RESTful APIs for easy integration with front-end systems.
## Functionalities
- Waste categories
- Recycling tips
- Disposal guidelines

## Core functionalities:
- CRUD operations for waste categories, recycling tips, and disposal guidelines.
- Input validation to ensure data integrity.
- Structured JSON responses.
- Error handling mechanisms.

## Tools and Technologies
- Framework: Spring Boot
- Database: H2 (In-memory database for development)
- Version Control: Git, GitHub
- IDE: IntelliJ IDEA
- Testing: JUnit for unit testing
- API Testing: Postman or cURL
- Documentation: Swagger for API documentation

## Testing

- JUnit 5: Unit and integration testing framework.

- Mockito: Mocking framework for isolating dependencies during tests.

- Spring Boot Test: For comprehensive testing of Spring components.

## Tools

- Maven: Dependency management and build automation.
- Postman: API testing.

## Installation and Setup
### Prerequisites

- Java 17 or higher.
- Maven (ensure it's installed and configured).
- Postman (optional for API testing).

#### Steps to Run the Application
Clone the Repository:

    git clone https://github.com/your-repo/waste-management-app.git
    cd \SustainableWasteManagementAPI\src\main\java\com\enviro\assessment\grad001\zannymaholobela> 
    run SustainableWasteManagementApiApplication.java

Build the Project:

    mvn clean install

Run the Application:

    mvn spring-boot:run

Access the Application:
The application will run on http://localhost:8080. Use Postman or your browser to test the API endpoints.

## API Endpoints

### WasteCategory Endpoints
| Method | Endpoint                  | Description                  |
|--------|---------------------------|------------------------------|
| GET    | `/api/waste-categories`   | Retrieve all waste categories |
| GET    | `/api/waste-categories/{id}` | Retrieve a waste category by ID |
| POST   | `/api/waste-categories`   | Create a new waste category   |
| PUT    | `/api/waste-categories/{id}` | Update a waste category       |
| DELETE | `/api/waste-categories/{id}` | Delete a waste category       |

### RecyclingTip Endpoints
| Method | Endpoint                | Description                  |
|--------|-------------------------|------------------------------|
| GET    | `/api/recycling-tips`   | Retrieve all recycling tips  |
| GET    | `/api/recycling-tips/{id}` | Retrieve a recycling tip by ID |
| POST   | `/api/recycling-tips`   | Create a new recycling tip   |
| PUT    | `/api/recycling-tips/{id}` | Update a recycling tip       |
| DELETE | `/api/recycling-tips/{id}` | Delete a recycling tip       |

### DisposalGuideline Endpoints
| Method | Endpoint                          | Description                           |
|--------|-----------------------------------|---------------------------------------|
| GET    | `/api/disposal-guidelines`        | Retrieve all disposal guidelines      |
| GET    | `/api/disposal-guidelines/{id}`   | Retrieve a disposal guideline by ID   |
| POST   | `/api/disposal-guidelines`        | Create a new disposal guideline       |
| PUT    | `/api/disposal-guidelines/{id}`   | Update a disposal guideline           |
| DELETE | `/api/disposal-guidelines/{id}`   | Delete a disposal guideline           |


### DisposalGuideline Endpoints
| Method | Endpoint                          | Description                           |
|--------|-----------------------------------|---------------------------------------|
| GET    | `/api/disposal-guidelines`        | Retrieve all disposal guidelines      |
| GET    | `/api/disposal-guidelines/{id}`   | Retrieve a disposal guideline by ID   |
| POST   | `/api/disposal-guidelines`        | Create a new disposal guideline       |
| PUT    | `/api/disposal-guidelines/{id}`   | Update a disposal guideline           |
| DELETE | `/api/disposal-guidelines/{id}`   | Delete a disposal guideline           |

### Admin Endpoints
| Method | Endpoint                           | Description                             |
|-----|------------------------------------|-----------------------------------------|
| POST | `/api/admin/waste-categories`      | Create a new user (admin only)            |
| PUT | `/api/admin/waste-categories/{id}` | Update user information                 |
| DELETE | `/api/admin/waste-categories/{id}` | Delete a user                           |

### Running Tests

Run Unit and Integration Tests:

        mvn test

### Contributors

Zanny Maholobela
