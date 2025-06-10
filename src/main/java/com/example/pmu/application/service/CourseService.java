package com.example.pmu.application.service;

import com.example.pmu.domain.model.Course;
import com.example.pmu.domain.port.CourseRepository;

import java.util.UUID;

public class CourseService {

    CourseRepository courseRepository;

    public CourseService (CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course create(Course course) {
        return null;
    }

    public Course getCourse(UUID id) {
        return null;
    }
}
