# FakeStoreProductService

## Project Description

FakeStoreProductService is a Spring Boot application that interacts with the FakeStore API to fetch product details. The application provides an API to retrieve product information by product ID. The purpose of this project is to demonstrate how to integrate with an external API and convert the data into a custom format.

## Setup and Run

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/ric-v/FakeStoreProductService.git
   cd FakeStoreProductService
   ```

2. Build the project:
   ```bash
   ./mvnw clean install
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080`.

## API Endpoints

[Postman Collection](https://documenter.getpostman.com/view/12893975/2sAYBPnEsg)

### Get Product by ID

- **URL:** `/products/{id}`
- **Method:** `GET`
- **Description:** Retrieves product details by product ID.
- **Response:**
  ```json
  {
    "id": 1,
    "title": "Product Title",
    "description": "Product Description",
    "price": 29.99,
    "category": {
      "id": 123,
      "title": "Category Title"
    }
  }
  ```

### Get All Products

- **URL:** `/products/`
- **Method:** `GET`
- **Description:** Retrieves all products.
- **Response:**
  ```json
  [
    {
      "id": 1,
      "title": "Product Title",
      "description": "Product Description",
      "price": 29.99,
      "category": {
        "id": 123,
        "title": "Category Title"
      }
    },
    {
      "id": 2,
      "title": "Another Product Title",
      "description": "Another Product Description",
      "price": 39.99,
      "category": {
        "id": 124,
        "title": "Another Category Title"
      }
    }
  ]
  ```

### Update Product

- **URL:** `/products/{id}`
- **Method:** `PUT`
- **Description:** Updates product details by product ID.
- **Request Body:**
  ```json
  {
    "title": "Updated Product Title",
    "description": "Updated Product Description",
    "price": 49.99,
    "category": {
      "id": 123,
      "title": "Updated Category Title"
    }
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "title": "Updated Product Title",
    "description": "Updated Product Description",
    "price": 49.99,
    "category": {
      "id": 123,
      "title": "Updated Category Title"
    }
  }
  ```

### Create Product

- **URL:** `/products`
- **Method:** `POST`
- **Description:** Creates a new product.
- **Request Body:**
  ```json
  {
    "title": "New Product Title",
    "description": "New Product Description",
    "price": 59.99,
    "category": {
      "id": 125,
      "title": "New Category Title"
    }
  }
  ```
- **Response:**
  ```json
  {
    "id": 3,
    "title": "New Product Title",
    "description": "New Product Description",
    "price": 59.99,
    "category": {
      "id": 125,
      "title": "New Category Title"
    }
  }
  ```

### Token Validation

- **URL:** `/users/validate/{token}`
- **Method:** `GET`
- **Description:** Validates a token and retrieves user details.
- **Response:**
  ```json
  {
    "name": "User Name",
    "email": "user@example.com",
    "role": [
      {
        "value": "ROLE_USER"
      }
    ]
  }
  ```
