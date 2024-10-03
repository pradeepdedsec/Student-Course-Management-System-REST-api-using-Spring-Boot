package com.sample.api.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.api.entity.Course;
import com.sample.api.entity.Teacher;
import com.sample.api.exception.TeacherNotFoundException;
import com.sample.api.repo.TeacherRepository;

public class TeacherServiceImpl  implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseService courseService;

    @Override
    public Teacher getTeacher(Long id) {
        return unwrapTeacher(teacherRepository.findById(id), id) ;
    }

    @Override
    public Teacher getTeacherByCourseId(Long courseId) {
        Course course=courseService.getCourse(courseId);
        return unwrapTeacher(teacherRepository.findByCourse(course), 0L);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
       return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher teacher=unwrapTeacher(teacherRepository.findById(id), id) ;
        teacherRepository.delete(teacher);
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    static Teacher unwrapTeacher(Optional<Teacher> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new TeacherNotFoundException(id);
    }
}
