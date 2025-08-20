# 🚀 Spring Boot User Management with Cloudinary

This project is a Spring Boot application designed to manage user information, including the storage of user profile pictures and resumes in Cloudinary, while persisting core user data in a PostgreSQL database.

## 🌟 Project Definition

This application provides a RESTful API for creating users. Each user can have a name, email, a profile picture, and a resume (e.g., PDF, DOCX, TXT, or other document types). The profile picture and resume files are uploaded to and served from Cloudinary, an external cloud-based media management service. User metadata (name, email, and the Cloudinary URLs) is stored in a PostgreSQL database.

## 🛠️ Technologies Used

- **Spring Boot**: Framework for building robust, stand-alone, production-grade Spring applications.
- **Java 17+**: The programming language used.
- **Maven**: Dependency management and build automation tool.
- **PostgreSQL**: Relational database for storing user data.
- **Spring Data JPA**: For easy interaction with the PostgreSQL database.
- **Cloudinary Java SDK**: For seamless integration with the Cloudinary API to upload and manage media files.
- **Lombok**: Reduces boilerplate code (getters, setters, constructors).

## 📦 Dependencies

The key dependencies used in this project, as configured in `pom.xml`, are:

```xml
<!-- Spring Boot Web Starter for building RESTful applications -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Data JPA for database interaction -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- PostgreSQL JDBC Driver -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Cloudinary Java SDK for file uploads -->
<dependency>
    <groupId>com.cloudinary</groupId>
    <artifactId>cloudinary-http44</artifactId>
    <version>1.35.0</version> <!-- Check for latest version if needed -->
</dependency>

<!-- Lombok for boilerplate code reduction -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- Spring Boot DevTools for development-time features -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>

<!-- Spring Boot Starter Test for testing -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

## ⬇️ How to Clone and Set Up

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/image-upload-test.git
cd image-upload-test
```

> **Note:** Replace `your-username` with the actual GitHub username where this project will be hosted.

### 2. Database Setup (PostgreSQL)

- Ensure you have a PostgreSQL database server running locally.
- Create a new database for this project (e.g., `devpos`).

### 3. Cloudinary Account Setup

- If you don't have one, sign up for a free Cloudinary account at [https://cloudinary.com/](https://cloudinary.com/).
- Once logged in, navigate to your Dashboard. You will find your **Cloud name**, **API Key**, and **API Secret** there. Keep these handy.

### 4. Configure application.properties

Open `src/main/resources/application.properties` and update the following sections with your database and Cloudinary credentials:

```properties
# PostgreSQL Database Configuration
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:postgresql://localhost:5432/devpos # Adjust port/DB name if different
spring.datasource.username=your_pg_username
spring.datasource.password=your_pg_password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# Cloudinary Configuration
cloudinary.cloud_name=your_cloudinary_cloud_name
cloudinary.api_key=your_cloudinary_api_key
cloudinary.api_secret=your_cloudinary_api_secret

# Image storage type (used as a flag in some larger applications)
image.storage.type=cloudinary

# Maximum file size for uploads (adjust as needed)
spring.servlet.multipart.max-file-size=20MB
spring.servlet.multipart.max-request-size=20MB
```

> **Important:** Replace the placeholder values (`your_pg_username`, `your_pg_password`, `your_cloudinary_cloud_name`, `your_cloudinary_api_key`, `your_cloudinary_api_secret`) with your actual credentials.

## ▶️ How to Run

### Using Maven

Navigate to the project root directory in your terminal and run:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` (or the port configured in `application.properties`).

## 🧪 How to Test (Using Postman or similar REST client)

Once the application is running, you can test the user creation and file upload functionality using a tool like Postman, Insomnia, or a simple HTML form.

### Endpoint

- **Method:** `POST`
- **URL:** `http://localhost:8080/api/users`

### Request Body Configuration (in Postman)

Select `form-data` for the request body.

Add the following key-value pairs:

| Key | Type | Value |
|-----|------|-------|
| `name` | Text | Jane Doe |
| `email` | Text | jane.doe@example.com |
| `profilePicFile` | File | (Select your profile image file) |
| `resumeFile` | File | (Select your resume PDF or document) |

### Expected Response

A successful request will return an HTTP `201 Created` status with the details of the newly created user, including the URLs for the profile picture and resume stored on Cloudinary.

```json
{
    "id": 1,
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "profilePicUrl": "https://res.cloudinary.com/your_cloud_name/image/upload/v.../user_profiles/...",
    "resumeUrl": "https://res.cloudinary.com/your_cloud_name/raw/upload/v.../user_resumes/..."
}
```
