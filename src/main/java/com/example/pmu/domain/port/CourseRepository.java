package com.example.pmu.domain.port;

import com.example.pmu.domain.model.Course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository {
    Course save(Course course);
    Optional<Course> findById(UUID id);
    List<Course> findAll();
}