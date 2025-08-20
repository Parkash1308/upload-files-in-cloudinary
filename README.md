🚀 Spring Boot User Management with Cloudinary

This project is a Spring Boot application designed to manage user information, including the storage of user profile pictures and resumes in Cloudinary, while persisting core user data in a PostgreSQL database.

---

🌟 Project Definition

This application provides a RESTful API for creating users. Each user can have a name, email, a profile picture, and a resume (e.g., PDF, DOCX, TXT, or other document types). The profile picture and resume files are uploaded to and served from Cloudinary, an external cloud-based media management service. User metadata (name, email, and the Cloudinary URLs) is stored in a PostgreSQL database.

---

🛠️ Technologies Used

- **Spring Boot**: Framework for building robust, stand-alone, production-grade Spring applications.  
- **Java 17+**: The programming language used.  
- **Maven**: Dependency management and build automation tool.  
- **PostgreSQL**: Relational database for storing user data.  
- **Spring Data JPA**: For easy interaction with the PostgreSQL database.  
- **Cloudinary Java SDK**: For seamless integration with the Cloudinary API to upload and manage media files.  
- **Lombok**: Reduces boilerplate code (getters, setters, constructors).  

---

📦 Dependencies (pom.xml)

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
    <version>1.35.0</version>
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
