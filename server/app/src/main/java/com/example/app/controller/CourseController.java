package com.example.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Course;

@RestController
public class CourseController {
	@GetMapping("/api/v1/course")
	public Course test() {
		return new Course(0L, "The Ohio State University", "CSE", 6341, "Foundations of Programming Languages");
	}    
}
