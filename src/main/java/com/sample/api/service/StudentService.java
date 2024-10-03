package com.sample.api.service;

import java.util.List;
import java.util.Set;

import com.sample.api.entity.Course;
import com.sample.api.entity.Guardian;
import com.sample.api.entity.Student;
import com.sample.api.entity.Teacher;

public interface StudentService {
    
    Student getStudent(Long id);
    Set<Student> getStudents();
    Set<Student> getStudentsByCourse(Course course);
    Set<Student> getStudentsByCourseId(Long id);
    Set<Student> getStudentsByCourseList(List<Course> courses);
    Set<Student> getStudentsByTeacher(Teacher teacher);
    Set<Student> getStudentsByTeacherId(Long id);
    Set<Student> getStudentsByTeacherList(List<Teacher> teachers);
    Set<Student> getStudentsByTeacherIdList(List<Long> idList);
    Set<Student> getStudentsByGaurdian(Guardian gaurdian);
    Set<Student> getStudentsByGaurdianName(String guardianName);
    Set<Student> getStudentsByGaurdianList(List<Guardian> gaurdians);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    Set<Course> getEnrolledCourses(Long id);
    public void insertData();
}
