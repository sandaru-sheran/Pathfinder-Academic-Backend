# University Management System (Security Project)

A robust University Management System built with Spring Boot, featuring role-based access control (RBAC), JWT-based authentication, and a complete set of features for Students, Lecturers, and Administrators.

## 🚀 Features

### 👤 User Management
- **Registration & Login**: Secure user creation and JWT-based authentication.
- **Role-Based Access**: Specialized endpoints for Admin, Lecturer, and Student.
- **Status Control**: Admins can toggle user account status (enabled/disabled).

### 🎓 Student Features
- **Course Catalog**: Browse available courses.
- **Enrollment**: Enroll in courses for specific semesters.
- **Transcript**: View personal academic records and grades.
- **Resources**: Access course materials and resources.

### 👨‍🏫 Lecturer Features
- **Allocated Courses**: View courses assigned to the lecturer.
- **Roster Management**: View students enrolled in their courses.
- **Grading**: Assign and update grades for students.
- **Resource Management**: Upload/Add resources to courses.

### 🛡️ Admin Features
- **Course Management**: Create and manage courses.
- **Program Management**: Manage academic programs.
- **Allocation**: Assign lecturers to courses.
- **Resource Control**: Oversee course resources.

## 🛠️ Tech Stack

- **Framework**: Spring Boot 3.x
- **Security**: Spring Security, JWT (JJWT)
- **Database**: MySQL
- **ORM**: Spring Data JPA (Hibernate)
- **API Documentation**: Swagger UI / OpenAPI 3 (SpringDoc)
- **Build Tool**: Maven
- **Utility**: Lombok

## ⚙️ Configuration

Before running the application, update the `src/main/resources/application.properties` file with your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/uni
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

# JWT Configuration
jwt.secret=your_secret_key_at_least_256_bits_long
jwt.expiration=86400000
```

## 🏗️ Getting Started

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   ```

2. **Database Setup**:
   - Create a MySQL database named `uni`.
   - The tables will be automatically created by Hibernate on the first run (`spring.jpa.hibernate.ddl-auto=update`).

3. **Build and Run**:
   ```bash
   ./mvnw spring-boot:run
   ```

## 📖 API Documentation

Once the application is running, you can access the Swagger UI to explore and test the APIs:

- **Swagger UI**: `http://localhost:8080/swagger-ui/index.html`
- **OpenAPI Doc**: `http://localhost:8080/v3/api-docs`

## 🔑 Authentication

Most endpoints require a JWT token. To authenticate:
1. Call `/api/user/login` with your credentials.
2. Copy the returned token.
3. Include it in the `Authorization` header of subsequent requests as: `Bearer <your_token>`.

---
Developed as a security-focused University Management System.
