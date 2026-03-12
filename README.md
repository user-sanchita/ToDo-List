# To-Do List Application

## Description

This is a simple **To-Do List REST API application** built using **Spring Boot**.
The application allows users to manage their daily tasks by creating, updating, viewing, and deleting tasks.

All APIs are secured using **JWT Authentication**, ensuring that only authenticated users can access protected endpoints.

---

## Features

* User authentication using JWT
* Add new tasks
* Update tasks
* Delete tasks
* View all tasks
* Secure REST APIs using Spring Security
* API documentation using Swagger UI
* Docker image build using Spring Boot

---

## Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* Swagger UI
* Docker

---

# Project Structure

```
controller
service
repository
model
security
config
```

---

# How to Run the Project

## 1. Clone the Repository

```
git clone https://github.com/user-sanchita/ToDo-List.git
cd To-Do-List
```

---

## 2. Build Docker Image

Run the following command to build the Docker image using Spring Boot:

```
./mvnw spring-boot:build-image
```

---

## 3. Run the Application

Run the container with the required environment variables:

```
#docker run -d -p 8080:8080 -e DB_URL=jdbc:mysql://host.docker.internal:3306/ToDo -e DB_USER=your_db_username -e DB_PWD=your_db_password todo-list:latest

```

---

# Environment Variables

Before running the application, set the following environment variables:

```
DB_URL=your_database_url
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password

```

---

# Database Setup

1. Install MySQL
2. Create a database named:
3. Use your own database username and password while running the container.

---

# API Documentation

After running the application, open Swagger UI to explore the available endpoints:

```
http://localhost:8080/swagger-ui.html
```

---

# Author

Sanchita Koley




