# GMall System

This repository contains the complete GMall system, including the backend, frontend, and database setup.

## Backend

The backend service is developed using Spring Boot and MyBatis Plus. It provides APIs for data management and interaction between the frontend and the database.

### Prerequisites

Before starting, ensure you have the following installed:

- **Java 17**
- **Maven 3.6+**
- **MySQL Server**
- **IDE (IntelliJ IDEA or Eclipse recommended)**

### Environment Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/wwwqqqzzz/gmall-system.git
   cd gmall-system/BackEnd
   ```

2. **Configure the MySQL database**:

   - Create a database for the project (e.g., `gmall`).
   - Update `application.yml` in the `src/main/resources` directory with your MySQL connection details:
     ```yaml
     server:
       ip: YOUR_SERVER_IP
       port: YOUR_SERVER_PORT
  
     spring:
       datasource:
         driver-class-name: com.mysql.cj.jdbc.Driver
         url: jdbc:mysql://YOUR_DATABASE_HOST:YOUR_DATABASE_PORT/YOUR_DATABASE_NAME?serverTimezone=GMT%2b8
         username: YOUR_DATABASE_USERNAME
         password: YOUR_DATABASE_PASSWORD
  
     mybatis:
       mapper-locations: classpath:mapper/*.xml
  
     mybatis-plus:
       configuration:
         log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  
     files:
       upload:
         path: YOUR_UPLOAD_PATH
     ```
     Replace the placeholders (e.g., `YOUR_SERVER_IP`, `YOUR_DATABASE_USERNAME`) with your specific values.

3. **Install dependencies**:

   ```bash
   mvn clean install
   ```

4. **Generate code (Optional)**:
   If you want to generate code for models, mappers, and services, configure `MyBatis Plus Generator` and run it.

### How to Run

1. **Start the application**:
   Run the application using your IDE or Maven:

   - **Using Maven**:
     ```bash
     mvn spring-boot:run
     ```
   - **Using IDE**:
     Locate the main class `com.GMall.BackEnd.BackEndApplication` and run it.

2. **Access the API**:
   By default, the application runs on port `9090`. You can access the APIs at:

   - Swagger UI: [http://YOUR_SERVER_IP:9090/swagger-ui/](http://YOUR_SERVER_IP:9090/swagger-ui/)

## Frontend

The frontend service is developed using Vue.js and ElementUI.

### Setup

1. **Navigate to the frontend directory**:

   ```bash
   cd gmall-system/FrontEnd
   ```

2. **Configure the server IP**:
   Update the `public/config.js` file with your backend server IP:

   ```javascript
   export const serverIp = 'YOUR_SERVER_IP';
   ```

3. **Install dependencies and start the frontend**:

   ```bash
   npm install
   npm run serve
   ```

4. **Access the frontend**:
   By default, the frontend runs on port `8080`. Open your browser and navigate to:

   ```
   http://localhost:8080
   ```

## Database

The database schema and initial data are included in the repository.

### Setup

1. **Locate the SQL script**:
   The SQL script is located in the `database` folder of the repository:

   ```bash
   cd gmall-system/database
   ```

2. **Import the database schema**:
   Run the SQL script to set up the required tables:

   ```bash
   mysql -u YOUR_DATABASE_USERNAME -p YOUR_DATABASE_NAME < gmall.sql
   ```

3. **Verify the database**:
   Ensure the tables and initial data are correctly imported by checking the database structure.

## Included Dependencies

- **Spring Boot Web**: For creating REST APIs.
- **MyBatis Plus**: For streamlined database interactions.
- **MySQL Connector**: For connecting to MySQL.
- **Lombok**: To reduce boilerplate code.
- **Swagger**: For API documentation.
- **Hutool**: A utility library for Java.
- **Apache POI**: For handling Excel files.
- **Java JWT**: For JSON Web Token authentication.

## Additional Notes

- Ensure MySQL is running and accessible before starting the application.
- Use Swagger for testing the APIs during development.
- Logs are stored in the default configuration; you can adjust logging levels in `application.yml`.

## Troubleshooting

- **Dependency Issues**:
  Run the following to resolve:

  ```bash
  mvn dependency:resolve
  ```

- **Port Conflicts**:
  Change the server port in `application.yml`:

  ```yaml
  server:
    port: 8081
  ```