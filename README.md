# Supplier Management System

A Spring Boot backend application for managing suppliers with PostgreSQL and Kafka integration.

## Features

- Create supplier
- Get supplier by ID
- Update supplier
- Delete supplier
- Kafka event publishing
- Kafka event consuming
- Swagger API documentation
- Global exception handling
- Validation handling
- Docker support

---

# Technologies Used

- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Apache Kafka
- Docker
- Swagger/OpenAPI
- Maven

---

# Project Structure

src/main/java/com/brightcore/supplier_management

- controller
- service
- repository
- entity
- dto
- kafka
- config
- exception

---

# API Endpoints

## Create Supplier

POST `/api/v1/suppliers/add`

### Request Body

```json
{
  "name": "ABC Supplies",
  "email": "abc@gmail.com",
  "phone": "0788888888",
  "company": "ABC Ltd",
  "address": "Kigali",
  "supplierCode":"cd1234",
  "contactPerson": "joe frank",
  "status": "Active",
  "suppliedProduct": "Rice"
}
```

---

## Get Supplier

GET `/api/v1/suppliers/{id}`

---

## Update Supplier

PUT `/api/v1/suppliers/update/{id}`

---

## Delete Supplier

DELETE `/api/v1/suppliers/delete/{id}`

---

# Swagger Documentation

Access Swagger UI:

http://localhost:8080/swagger-ui.html

---

# Kafka Events

The application publishes Kafka events for:

- SUPPLIER_CREATED
- SUPPLIER_UPDATED
- SUPPLIER_DELETED

Kafka consumer logs received events in console.

---

# Database Configuration

Database name:

supplier_db

PostgreSQL port:

5432

---

# Running the Application

## Run Kafka

```bash
docker compose up -d
```

---

## Run Spring Boot Application

```bash
mvn spring-boot:run
```

---

# Docker Build

```bash
docker build -t supplier-management .
```

---

# Author

Muragwa Hirwa Christian