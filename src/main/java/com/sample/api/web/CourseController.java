package com.sample.api.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.api.entity.Course;
import com.sample.api.service.CourseService;

@RestController
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course) {
        return this.courseService.saveCourse(course);
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable Long id) {
        return this.courseService.getCourse(id);
    }

    @PutMapping("/course")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        this.courseService.deleteCourse(id);
    }
}
