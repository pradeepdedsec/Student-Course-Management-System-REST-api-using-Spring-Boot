package com.sample.api.service;

import java.util.List;

import java.util.Optional;


import com.sample.api.entity.Teacher;
import com.sample.api.exception.TeacherNotFoundException;

public interface TeacherService {
    Teacher getTeacher(Long id);
    Teacher getTeacherByCourseId(Long courseId);
    Teacher saveTeacher(Teacher teacher);
    void deleteTeacher(Long id);
    List<Teacher> getTeachers();
    static Teacher unwrapTeacher(Optional<Teacher> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new TeacherNotFoundException(id);
    }
}
