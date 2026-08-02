# Employee Management System (EMS)

A full-stack web application designed to efficiently manage employee records. Built with a robust Java Spring Boot backend and a responsive React frontend, this project demonstrates scalable architecture, containerized deployment using Docker, and comprehensive automated testing.

## Features

### Backend Architecture
* **RESTful API:** Clean, standard-compliant endpoints for all CRUD operations.
* **Database Integration:** Seamlessly integrated with MySQL using Spring Data JPA and Hibernate for ORM.
* **Automated Testing:** Extensive test coverage using JUnit 5 and Mockito, leveraging an in-memory H2 database for isolated integration testing without risking production data.
* **Containerization:** Fully containerized using Docker and Docker Compose for instant, reliable deployment across any environment.

### Frontend Architecture
* **Split-Screen UI:** A responsive, side-by-side layout ensuring the data table and data-entry forms are accessible simultaneously.
* **Advanced Filtering:** Client-side search by name/code, dropdown filtering by Department and Manager, and dynamic date-range filtering.
* **Pagination:** Efficiently handles large datasets by paginating records (e.g., 5 rows per page) to ensure smooth performance.
* **Sequential Indexing:** Maintains clean, sequential row numbers dynamically, independent of absolute database primary keys.
* **State Management:** Utilizes React Hooks (`useState`, `useEffect`) for dynamic DOM updates and API synchronization.

## Comprehensive Technology Stack

### Backend
* **Language:** Java (LTS - 17/21)
* **Framework:** Spring Boot
* **Web Layer:** Spring Web (REST Controllers)
* **Data Access:** Spring Data JPA, Hibernate
* **Database (Production):** MySQL
* **Database (Testing):** H2 In-Memory Database
* **Testing Frameworks:** JUnit 5, Mockito, MockMvc
* **Build Tool:** Maven

### Frontend
* **Library:** React 18
* **Build Tool:** Vite
* **HTTP Client:** Axios (for API communication)
* **Styling:** CSS3 (Custom Flexbox Grid, Responsive Media Queries)
* **Components:** Functional Components with React Hooks

### DevOps & Deployment
* **Container Engine:** Docker
* **Orchestration:** Docker Compose
* **Web Server (Frontend):** Nginx (via Docker multi-stage builds)

## 📁 Core Project Structure

### Backend (`src/main/java/com/project/employee_management/`)
* `controller/EmployeeController.java` - Handles HTTP requests (`GET`, `POST`, `PUT`, `DELETE`).
* `model/Employee.java` - JPA Entity mapping to the `employees` database table.
* `repository/EmployeeRepository.java` - Interface extending `JpaRepository` for automated database queries.
* `resources/application.properties` - Configuration for database connections and Hibernate behavior.

### Frontend (`src/`)
* `App.jsx` - Main application wrapper.
* `EmployeeList.jsx` - Core component rendering the data table, search filters, and pagination.
* `EmployeeForm.jsx` - Component handling the side-panel UI for adding and editing employees.
* `services/api.js` - Centralized Axios configuration for making backend HTTP requests.
* `app.css` - Global stylesheets and layout definitions.

## 📋 Prerequisites

Before running the application locally, ensure you have the following installed:
* Java (JDK 17 or 21)
* Node.js (v18+)
* MySQL (v8.0+)
* Docker & Docker Compose (Optional, for containerized run)

##  Local Setup Instructions

### 1. Database Configuration
1. Open MySQL and create a database named `employee`:
   ```sql
   CREATE DATABASE employee;
2. The application is configured to auto-generate the required tables upon startup using spring.jpa.hibernate.ddl-auto=update.

###  2. Backend Setup
1. Navigate to the backend directory.
2. Update src/main/resources/application.properties with your MySQL credentials:
    ```java
   spring.datasource.username=root
   spring.datasource.password=your_password
3. Run the Spring Boot application:
    ```bash
   mvn spring-boot:run
The server will start on http://localhost:8080.

### 3. Frontend Setup
1. Navigate to the frontend directory.
2. Install dependencies:
    ```bash
   npm install
3. Start the Vite development server:
    ```bash
   npm run dev
The frontend will be available at http://localhost:5173.
### 🐳 Docker Setup (Recommended)
To run the entire stack (Database, Backend, and Frontend) with a single command, ensure Docker is running and execute:

    docker-compose up --build
* Frontend: http://localhost:5173
* Backend API: http://localhost:8080
* MySQL: Port 3306
### 📡 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/v1/employees` | Retrieve all employees |
| **POST** | `/api/v1/employees` | Create a new employee |
| **PUT** | `/api/v1/employees/{id}` | Update an existing employee |
| **DELETE** | `/api/v1/employees/{id}` | Delete an employee |

### 👨💻 Author

##### Rajnish Chauhan
* B.Tech Computer Science & Engineering, Neelkanth Institute of Technology
* Focus: Backend Development, Software Architecture, REST APIs