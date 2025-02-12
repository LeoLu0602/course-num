package com.example.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Course;
import com.example.app.repository.CourseRepository;

@RestController
public class CourseController {

	private final CourseRepository courseRepository;

	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@GetMapping("/api/v1/courses")
	public Iterable<Course> findAllCourses() {
		return this.courseRepository.findAll();
	}    
}
