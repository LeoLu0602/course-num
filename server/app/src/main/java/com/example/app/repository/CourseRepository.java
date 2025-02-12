package com.example.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
    
}
