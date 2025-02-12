package com.example.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String school;
    private String department;
    private int num;
    private String title;

    protected Course() {}

    public Course(String school, String department, int num, String title) {
        this.school = school;
        this.department = department;
        this.num = num;
        this.title = title;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return this.id;
    }

    public String getSchool() {
        return this.school;
    }

    public String getDepartment() {
        return this.department;
    }

    public int getNum() {
        return this.num;
    }

    public String getTitle() {
        return this.title;
    }
}
