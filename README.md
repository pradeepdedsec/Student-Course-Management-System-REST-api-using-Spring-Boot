# Student-Course-Management-System-REST-api-using-Spring-Boot



This project is a Student Course Management System built using Spring Boot, with functionalities for managing students, courses, teachers, and guardians. The system supports creating, retrieving, updating, and deleting data related to student enrollments, course materials, and teacher assignments, with a MySQL database backend.


# Features

1.CRUD Operations for students, courses, teachers, and guardians.

2.Data Relationships between students, courses, and teachers.

3.Exception Handling for resource not found and data integrity violations.

4.RESTful API design with endpoints for retrieving and managing data.

5.Database Initialization using test data at startup.




# Technologies Used

1.Java 17.

2.Spring Boot 3.3.3.

3.Spring Data JPA.

4.MySQL for database.

5.Hibernate for ORM.

6.Lombok for reducing boilerplate code.

7.Maven for dependency management.



# Endpoints

1.GET / - Initialize and load sample data.

2.GET /Data - Retrieve students by guardian.

3.GET /students - Get all students.

4.POST /students - Add a new student.

5.GET /courses/{id}/students - Get students enrolled in a course.

6.DELETE /students/{id} - Delete a student by ID.





# Setup Instructions

git clone https://github.com/pradeepdedsec/student-course-management-system.git



# Navigate to the project directory

cd student-course-management-system.





# Configure the MySQL database in application.properties:


spring.datasource.url=jdbc:mysql://localhost:3306/DBtest?useSSL=false&serverTimezone=UTC.

spring.datasource.username=root.

spring.datasource.password=yourpassword.



# Build and run the project:

mvn spring-boot:run.
