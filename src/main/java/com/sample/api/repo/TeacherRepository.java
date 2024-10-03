package com.sample.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.api.entity.Course;
import com.sample.api.entity.Teacher;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findByCourse(Course course);
    List<Teacher> findByFirstName(String firstName);
    List<Teacher> findByLastName(String lastName);
}
