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
