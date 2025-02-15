package com.example.app.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Course> getMethodName(
		@RequestParam(value = "school", defaultValue = "") String school,
		@RequestParam(value = "department", defaultValue = "") String department,
		@RequestParam(value = "num", defaultValue = "") int num
	) {
		Optional<Course> course = courseRepository.findBySchoolAndDepartmentAndNum(school, department, num);
        
		if (course.isPresent()) {
			return ResponseEntity.ok(course.get());
		}

		return ResponseEntity.badRequest().build();
	}
}
