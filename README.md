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

1. GET /                   - Initialize and load sample data.

2. GET /data               - Retrieve students by guardian.

3. GET /student/{id}       - Get a specific student by ID.

4. GET /teacher/{id}       - Get a specific teacher by ID.

5. GET /course/{id}        - Get a specific course by ID.

6. GET /actuator           - Actuator root web endpoint.

7. GET /actuator/mappings  - Actuator web endpoint 'mappings'.

8. POST /student           - Add a new student.

9. POST /teacher           - Add a new teacher.

10. POST /course           - Add a new course.

11. PUT /student           - Update student details.

12. PUT /teacher           - Update teacher details.

13. PUT /course            - Update course details.

14. DELETE /student/{id}   - Delete a student by ID.

15. DELETE /teacher/{id}   - Delete a teacher by ID.

16. DELETE /course/{id}    - Delete a course by ID.



# Setup Instructions

git clone https://github.com/pradeepdedsec/Student-Course-Management-System-REST-api-using-Spring-Boot.git



# Navigate to the project directory

cd student-course-management-system.





# Configure the MySQL database in application.properties:


spring.datasource.url=jdbc:mysql://localhost:3306/DBtest?useSSL=false&serverTimezone=UTC.

spring.datasource.username=root.

spring.datasource.password=yourpassword.



# Build and run the project:

mvn spring-boot:run.
