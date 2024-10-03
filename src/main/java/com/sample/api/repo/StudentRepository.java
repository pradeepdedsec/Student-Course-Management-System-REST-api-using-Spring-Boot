package com.sample.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.api.entity.Student;
import com.sample.api.entity.Course;
import com.sample.api.entity.Guardian;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    Set<Student> findByFirstName(String firstName);
    Set<Student> findByLastName(String lastName);
    Set<Student> findByEmailId(String emailId);
    Set<Student> findByCoursesIn(List<Course> courses);
    Set<Student> findByGuardianName(String guardianName);
    Set<Student> findByGuardian(Guardian guardian);
    Set<Student> findByGuardianIn(List<Guardian> guardians);
    Set<Student> findByGuardianNameIn(List<String> guardianNames); 
}
