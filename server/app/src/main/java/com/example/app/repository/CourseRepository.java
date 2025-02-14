package com.example.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.app.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findBySchoolAndDepartmentAndNum(String school, String department, int num);
}
