# capitole-inditex

## Overview

This project is a Spring Boot application that provides an API for managing product prices. It allows users to retrieve prices based on specific criteria, such as date, product ID, and brand ID. The application have a BD H2.

## Features

- Retrieve product prices based on date, product ID, and brand ID
- RESTful API for easy interaction

## Technologies Used

- **Java**: 17
- **Spring Boot**: 3.3.4
- **JUnit**: 5.4 for testing
- **Maven**: for dependency management

## Getting Started

### Prerequisites

- Java 17
- Maven

### Installation and deploy

1. Clone the repository:

   ```bash
   git clone https://github.com/jtgutierrez26/capitole-inditex.git
   cd capitole-inditex
   
2. The project must be compiled:
   ``` 
   mvn clean install 
   ```

3. The project must be run:
   ``` 
   mvn spring-boot:run
   ```


### API Endpoints

GET
http://localhost:8080/prices/product/{idProduct}/brand/{idBrand}?date={date}