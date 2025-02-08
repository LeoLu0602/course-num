package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@GetMapping("/api/v1/course")
	public Course test() {
		return new Course(0L, "CSE", 6341);
	}    
}
