package com.sample.api.service;

import java.util.Optional;
import java.util.Set;



import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.api.entity.Course;
import com.sample.api.entity.Student;
import com.sample.api.exception.CourseNotFoundException;
import com.sample.api.repo.CourseRepository;
import com.sample.api.repo.StudentRepository;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepo;
    
    @Override
    public Course getCourse(Long id) {
        return unwrapCourse(courseRepository.findById(id), id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {  
        Course course=unwrapCourse(courseRepository.findById(id), id);
        courseRepository.delete(course);      
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Course> getCourses() {
        return (Set<Course>)courseRepository.findAll();
    }

    @Override
    public Course addStudentToCourse(Long studentId, Long courseId) {
        Course course = getCourse(courseId);
        Optional<Student> student = studentRepo.findById(studentId);
        Student unwrappedStudent = StudentServiceImpl.unwrapStudent(student, studentId);
        course.getStudents().add(unwrappedStudent);
        return courseRepository.save(course);
    }

    @Override
    public Set<Student> getEnrolledStudents(Long id) {
        Course course = getCourse(id);
        return course.getStudents();
    }

    static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new CourseNotFoundException(id);
    }

    @Override
    public Course getCourseByTeacherId(Long id) {
        return unwrapCourse(courseRepository.findByTeacherId(id), 0L) ;
    }

    
}
