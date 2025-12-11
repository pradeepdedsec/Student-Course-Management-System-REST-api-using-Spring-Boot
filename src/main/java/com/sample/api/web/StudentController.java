package com.sample.api.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.api.entity.Student;
import com.sample.api.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class StudentController {
    
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public Student postMethodName(@RequestBody Student student) {        
        return this.studentService.saveStudent(student);
    }
    

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id) {
        return this.studentService.getStudent(id);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {        
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        this.studentService.deleteStudent(id);
    }

}
