package com.sample.api.service;

import java.util.Set;

import java.util.Optional;

import com.sample.api.entity.Course;
import com.sample.api.entity.Student;
import com.sample.api.exception.CourseNotFoundException;



public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);    
    Course addStudentToCourse(Long studentId, Long courseId);
    Course getCourseByTeacherId(Long id);
    Set<Course> getCourses();
    Set<Student> getEnrolledStudents(Long id);
    static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new CourseNotFoundException(id);
    }
}