package com.sample.api.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.api.entity.Teacher;
import com.sample.api.service.TeacherService;

@RestController
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/teacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return this.teacherService.saveTeacher(teacher);
    }

    @GetMapping("/teacher/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return this.teacherService.getTeacher(id);
    }

    @PutMapping("/teacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return this.teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/teacher/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        this.teacherService.deleteTeacher(id);
    }

}
