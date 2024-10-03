package com.sample.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.api.entity.Course;
import com.sample.api.entity.CourseMaterial;

import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
    List<CourseMaterial> findByCourse(Course course);
    List<CourseMaterial> findByUrl(String url);
}
