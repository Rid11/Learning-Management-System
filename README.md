# Lesson Management System - RESTful API  :rocket:

A robust and secure RESTful API for managing lessons, products, users, and roles within a learning management system. This project demonstrates best practices in backend development, utilizing the Spring ecosystem for a modular, maintainable, and highly secure application.

## Table of Contents

1. Features
2. Technologies Used
3. Project Structure
4. Getting Started
5. Prerequisites
6. Cloning the Repository
7. Database Setup
8. Running the Application
9. API Endpoints
10. Authentication
11. Products
12. Lessons
13. Security Implementation
14. Role-Based Authorization
15. Contributing
16. License

# Features

1. [ ] User & Role Management: Comprehensive CRUD operations for users and their associated roles.
2. [ ] Role-Based Access Control (RBAC): Granular authorization rules ensure only users with specific roles can access particular API endpoints and perform actions.
3. [ ] Product Management: Full CRUD capabilities for managing products available in the system.
4. [ ] Lesson Management: Full CRUD capabilities for managing educational lessons.
5. [ ] RESTful API Design: Adheres to REST principles for clean, predictable, and scalable API endpoints.
6. [ ] Secure Authentication: Implements HTTP Basic Authentication combined with robust password hashing using BCrypt.
7. [ ] Modular Architecture: Organized into distinct layers (DAO, Service, REST, Entity) for clear separation of concerns.

# Technologies Used

1. [ ] Java 17+
2. [ ] Spring Boot 3.5.3: The framework for building production-ready Spring applications quickly.
3. [ ] Spring Data JPA: Simplifies data access and persistence with JPA repositories.
4. [ ] Spring Security 6+: Provides authentication, authorization, and protection against common vulnerabilities.
5. [ ] MySQL 8.0+: The relational database used for storing all application data.
6. [ ] Hibernate: The JPA implementation used by Spring Data JPA for object-relational mapping.
7. [ ] Maven: The primary build automation tool for managing dependencies and project lifecycle.

# Project Structure
The project is organized into a standard Spring Boot layered architecture to promote modularity and separation of concerns:

* src/main/java/com/alabelewe/learningmanagementsystem/
* entity/       --> JPA entities (e.g., Lesson, Product, Role, User) - represents database tables.
* dao/          --> Data Access Objects (Spring Data JPA repositories) - interfaces for database operations.
* service/      --> Service layer - contains business logic, transaction management, and orchestrates DAO calls.
* rest/         --> REST controllers - exposes API endpoints and handles incoming HTTP requests.
* security/     --> Spring Security configuration - defines authentication and authorization rules.
* LearningmanagementsystemApplication.java # Main Spring Boot application entry point.

# Getting Started

Follow these steps to set up and run the Learning Management System RESTful API on your local machine.

# Prerequisites

Before you begin, ensure you have the following installed:

1. Java Development Kit (JDK) 17 or higher
2. Maven 3.6.3 or higher
3. MySQL 8.0 or higher
4. A REST client (e.g., Postman, Insomnia, curl) to test the API endpoints.

# Cloning the Repository

First, clone the project from GitHub:

git clone https://github.com/Rid11/Learning-Management-System
cd Learning-Management-System

# Database Setup

Create a MySQL Database:
Open your MySQL client (e.g., MySQL Workbench, command line) and create a new database.

CREATE DATABASE  IF NOT EXISTS `product_directory`;
USE `product_directory`;

# Configure Database Connection: 

Open the src/main/resources/application.properties file in your project and update the database connection details to match your MySQL setup:


`spring.datasource.url=jdbc:mysql://localhost:3306/product_directory
spring.datasource.username=springstudent
spring.datasource.password=springstudent`


# Running the Application

You can run the Spring Boot application using Maven:

mvn spring-boot:run

The application will start on http://localhost:8080

# API Endpoints

The API is secured using HTTP Basic Authentication. You will need to provide a valid username and password in the Authorization header for all requests.

Base URL: http://localhost:8080/app

# Authentication

Provide your username and password in the Authorization header using Basic Auth (e.g., in Postman, select "Basic Auth" and enter credentials).


# Products

| HTTP Method | Endpoint                  | Required Roles | Description                |
|-------------|---------------------------|----------------|----------------------------|
| GET         | /app/products             | EMPLOYEE       | Get all products           |
| GET         | /app/products{productId}  | EMPLOYEE       | Get a single product byID  |
| POST        | /app/products             | MANAGER        | Add a new product          |
| PUT         | /app/products             | MANAGER        | Update an existing product |
| DELETE      | /app/products/{productId} | ADMIN          | Delete a product by ID     |

# Lessons


| HTTP Method | Endpoint                 | Required Roles | Description                |
|-------------|--------------------------|----------------|----------------------------|
| GET         | /app/lessons             | EMPLOYEE       | Get all products           |
| GET         | /app/lessons{lessonId}   | EMPLOYEE       | Get a single product byID  |
| POST        | /app/lessons             | MANAGER        | Add a new product          |
| PUT         | /app/lessons             | MANAGER        | Update an existing product |
| DELETE      | /app/lessons/{lessonsId} | ADMIN          | Delete a product by ID     |


# Security Implementation

The application's security is managed by Spring Security, configured in com.alabelewe.learningmanagementsystem.security.SecurityConfig.

1. [ ] HTTP Basic Authentication: Users are authenticated by providing a username and password in the HTTP Authorization header.
 
3. [ ] BCrypt Password Encoding: Passwords stored in the database are securely hashed using BCryptPasswordEncoder to protect against brute-force attacks and unauthorized access.
 
5. [ ] DAO Authentication Provider: This component integrates with your custom UserService to load user details and roles from the application's MySQL database during the authentication process.


# Role-Based Authorization

Requests are intercepted by a SecurityFilterChain.

Access to specific URLs and HTTP methods (GET, POST, PUT, DELETE) is restricted based on the authenticated user's roles (ROLE_EMPLOYEE, ROLE_MANAGER, ROLE_ADMIN). This ensures granular control over who can perform what actions.

CSRF Protection Disabled: For this stateless REST API, Cross-Site Request Forgery (CSRF) protection is disabled. This is a common practice when using token-based authentication like HTTP Basic, as CSRF relies on session management which is not typically present in stateless APIs.

# Contributing
Contributions, issues, and feature requests are welcome!.

# License
This project is open-source and available under the MIT License.

Contact
Your Name: OSEIN RIDWAN ALABELEWE
Email: oseinridwan5@gmail.com
GitHub: @rid11


