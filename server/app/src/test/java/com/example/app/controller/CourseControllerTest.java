package com.example.app.controller;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.example.app.model.Course;
import com.example.app.repository.CourseRepository;

@WebMvcTest
public class CourseControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseRepository courseRepository;

    private Course mockCourse;

    @BeforeEach
    void setUp() {
        this.mockCourse = new Course("The Ohio State University", "CSE", 6341, "Foundation of Programming Languages");
    }

    @Test
    void testGetCourse() throws Exception {
        when(courseRepository.findBySchoolAndDepartmentAndNum("The Ohio State University", "CSE", 6341))
            .thenReturn(Optional.of(mockCourse));

        mockMvc.perform(get("/api/v1/courses")
                .param("school", "The Ohio State University")
                .param("department", "CSE")
                .param("num", "6341"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Foundation of Programming Languages"));
    }
}

