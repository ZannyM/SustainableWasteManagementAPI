# Sustainable Waste Management API

A RESTful API for sustainable waste management, providing information on waste categories, recycling tips, and disposal guidelines.

## Features

- **Waste Categories Management**: Add, update, retrieve, and delete waste categories
- **Recycling Tips**: Get actionable insights on how to recycle different materials
- **Disposal Guidelines**: Retrieve best practices for safe and sustainable disposal
- **Firebase Authentication**: Secure endpoints with Firebase Auth
- **Role-Based Access Control**: Different access levels for users and admins
- **Performance Optimization**:
    - Caching 
    - Rate limiting to prevent abuse
- **API Documentation**: Swagger/OpenAPI documentation
- **Monitoring**: Application health metrics and performance monitoring

### Prerequisites

- Java 17
- Spring Boot 3.x
- Maven 3.6+
- Spring Security
- Firebase Authentication
- H2 Database (for development)
- Swagger/OpenAPI
- Actuator & Micrometer (for monitoring)
- Postman (API Testing)

## Getting Started

1. Clone the repository:

        git clone https://github.com/ZannyM/SustainableWasteManagementAPI

2. Set up environment variables:

        export FIREBASE_PROJECT_ID=your-project-id
        export FIREBASE_PRIVATE_KEY="-----BEGIN PRIVATE KEY-----\nYourKey\n-----END PRIVATE KEY-----\n"
        export FIREBASE_CLIENT_EMAIL=your-service-account-email

3. Build the project:

        mvn clean install

4. Run the application:

         mvn spring-boot:run

5. Access the API at:

        http://localhost:8080

6. Access the API documentation at:

         http://localhost:8080/swagger-ui.html


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

### Authentication

- `POST /api/auth/register` - Register a new user

## Security

- Public endpoints: GET operations on waste categories, recycling tips, and disposal guidelines
- Protected endpoints: POST, PUT, DELETE operations (require authentication)
- Admin endpoints: Special operations for administrators

## Monitoring

- Application health: `http://localhost:8080/actuator/health`
- Metrics: `http://localhost:8080/actuator/metrics`
- Prometheus metrics: `http://localhost:8080/actuator/prometheus`

## Testing

- JUnit 5: Unit and integration testing framework.

- Mockito: Mocking framework for isolating dependencies during tests.

- Spring Boot Test: For comprehensive testing of Spring components.

### Running Tests

Run Unit and Integration Tests:

        mvn test
## License

This project is licensed under the MIT License - see the LICENSE file for details.

### Contributors

Zanny Maholobela
