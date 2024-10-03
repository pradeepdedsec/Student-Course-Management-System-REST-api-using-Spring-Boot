# Student-Course-Management-System-REST-api-using-Spring-Boot



This project is a Student Course Management System built using Spring Boot, with functionalities for managing students, courses, teachers, and guardians. The system supports creating, retrieving, updating, and deleting data related to student enrollments, course materials, and teacher assignments, with a MySQL database backend.


#Features

CRUD Operations for students, courses, teachers, and guardians
Data Relationships between students, courses, and teachers
Exception Handling for resource not found and data integrity violations
RESTful API design with endpoints for retrieving and managing data
Database Initialization using test data at startup




#Technologies Used

Java 17
Spring Boot 3.3.3
Spring Data JPA
MySQL for database
Hibernate for ORM
Lombok for reducing boilerplate code
Maven for dependency management



#Endpoints

GET / - Initialize and load sample data
GET /Data - Retrieve students by guardian
GET /students - Get all students
POST /students - Add a new student
GET /courses/{id}/students - Get students enrolled in a course
DELETE /students/{id} - Delete a student by ID





#Setup Instructions

git clone https://github.com/your-username/student-course-management-system.git



#Navigate to the project directory

cd student-course-management-system





#Configure the MySQL database in application.properties:


spring.datasource.url=jdbc:mysql://localhost:3306/DBtest?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=yourpassword



#Build and run the project:

mvn spring-boot:run
