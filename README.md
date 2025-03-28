## Sustainable Waste Management API
A RESTful API for sustainable waste management, providing information on waste categories, recycling tips, and disposal guidelines.

### Features

- **Waste Categories Management**: Add, update, retrieve, and delete waste categories
- **Recycling Tips**: Get actionable insights on how to recycle different materials
- **Disposal Guidelines**: Retrieve best practices for safe and sustainable disposal
- **Spring Security Authentication**: Simple and secure username/password authentication
- **Role-Based Access Control**: Different access levels for users and admins
- **Soft Delete Functionality**: Preserves data relationships while allowing "deletion"
- **Performance Optimization**:
    - Caching for improved response times
    - Rate limiting to prevent API abuse


- **API Documentation**: Swagger/OpenAPI documentation
- **Monitoring**: Application health metrics and performance monitoring

### Prerequisites

- Java 17
- Spring Boot 3.x
- Maven 3.6+
- Spring Security
- H2 Database (for development)
- Swagger/OpenAPI
- Actuator & Micrometer (for monitoring)
- Postman (API Testing)

### Getting Started

Clone the repository:

    git clone https://github.com/ZannyM/SustainableWasteManagementAPI

Build the project:

    mvn clean install

Run the application:

    mvn spring-boot:run

Access the API at:

    http://localhost:8080

Access the API documentation at:

    http://localhost:8080/swagger-ui/index.html

### Authentication
The API uses Spring Security with basic authentication:
#### Regular User:
Can perform standard operations
- Username: `user`
- Password: `password`
- 
#### Admin User:
Has access to all endpoints including admin operations
- Username: `admin`
- Password: `admin`

## API Endpoints

### WasteCategory Endpoints
| Method | Endpoint                     | Description                     | Authentication |
|--------|------------------------------|---------------------------------|----------------|
| GET    | `/api/waste-categories`      | Retrieve all waste categories   | None           |
| GET    | `/api/waste-categories/{id}` | Retrieve a waste category by ID | None           |
| POST   | `/api/waste-categories`      | Create a new waste category     | Required       |
| PUT    | `/api/waste-categories/{id}` | Update a waste category         | Required       |
| DELETE | `/api/waste-categories/{id}` | Soft-delete a waste category    | Required       |

### RecyclingTip Endpoints
| Method | Endpoint                   | Description                    | Authentication  |
|--------|----------------------------|--------------------------------|-----------------|
| GET    | `/api/recycling-tips`      | Retrieve all recycling tips    | None            |
| GET    | `/api/recycling-tips/{id}` | Retrieve a recycling tip by ID | None            |
| POST   | `/api/recycling-tips`      | Create a new recycling tip     | Required        |
| PUT    | `/api/recycling-tips/{id}` | Update a recycling tip         | Required        |
| DELETE | `/api/recycling-tips/{id}` | Soft-delete a recycling tip    | Required        |

### DisposalGuideline Endpoints
| Method | Endpoint                          | Description                           | Authentication|
|--------|-----------------------------------|---------------------------------------|---------------|
| GET    | `/api/disposal-guidelines`        | Retrieve all disposal guidelines      | None          |
| GET    | `/api/disposal-guidelines/{id}`   | Retrieve a disposal guideline by ID   | None          |
| POST   | `/api/disposal-guidelines`        | Create a new disposal guideline       | Required      |
| PUT    | `/api/disposal-guidelines/{id}`   | Update a disposal guideline           | Required      |
| DELETE | `/api/disposal-guidelines/{id}`   | Soft-delete a disposal guideline      | Required      |

### Admin Endpoints
| Method | Endpoint                           | Description                             | Authentication |
|--------|------------------------------------|-----------------------------------------|----------------|
| POST   | `/api/admin/waste-categories`      | Create a new user (admin only)          | Admin Only     |
| PUT    | `/api/admin/waste-categories/{id}` | Update user information                 | Admin Only     |
| DELETE | `/api/admin/waste-categories/{id}` | Delete a user                           | Admin Only     |

### Authentication Endpoints
| Method | Endpoint            | Description                     | Authentication |
|--------|---------------------|---------------------------------|----------------|
| GET    | `/api/auth/me`      | Get current user information    | Required       |

### Soft Delete Implementation
This API implements a soft delete approach:
- Records are not physically removed from the database
- Instead, they are marked as inactive with an `active` flag
- This preserves data relationships and prevents constraint violations
- Only active records are returned by default in API responses

### Security
- Public endpoints: GET operations on waste categories, recycling tips, and disposal guidelines
- Protected endpoints: POST, PUT, DELETE operations (require authentication)
- Admin endpoints: Special operations for administrators only

### Monitoring
- Application health: `http://localhost:8080/actuator/health`
- Metrics: `http://localhost:8080/actuator/metrics`
- Prometheus metrics: `http://localhost:8080/actuator/prometheus`

###Testing
- JUnit 5: Unit and integration testing framework
- Mockito: Mocking framework for isolating dependencies during tests
- Spring Boot Test: For comprehensive testing of Spring components
 -Swagger UI: For interactive API testing

### Running Tests
Run Unit and Integration Tests:

    mvn test
    
#### License
This project is licensed under the MIT License - see the LICENSE file for details.
#### Contributors
Zanny Maholobela
