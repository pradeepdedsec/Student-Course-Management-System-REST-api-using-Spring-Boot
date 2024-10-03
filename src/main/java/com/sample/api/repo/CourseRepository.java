package com.sample.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.api.entity.Course;

import java.util.Optional;
import java.util.Set;
import com.sample.api.entity.Student;


import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Set<Course> findByStudents(Set<Student> students);
    Set<Course> findByTitle(String title);
    Set<Course> findByCredits(int credits);
    Optional<Course> findByTeacherId(Long id);
}
