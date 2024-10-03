package com.sample.api.web;

import org.springframework.web.bind.annotation.RestController;

import com.sample.api.entity.Student;
import com.sample.api.service.StudentService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AppController {

    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public String getMethodName() {
        studentService.insertData();
        return "hello world";
    }

    @GetMapping("/Data")
    public Set<Student> getMethodName2() {
        return studentService.getStudentsByGaurdian(null);
    }
    
}
