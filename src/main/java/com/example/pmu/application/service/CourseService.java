package com.example.pmu.application.service;

import com.example.pmu.domain.model.Course;
import com.example.pmu.domain.port.CourseRepository;
import com.example.pmu.infrastructure.secondary.persistence.OutboxEventJpaEntity;
import com.example.pmu.infrastructure.secondary.persistence.OutboxEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;

import java.util.UUID;

public class CourseService {

    private final CourseRepository courseRepository;
    private final OutboxEventRepository outboxRepo;
    private final ObjectMapper mapper;

    public CourseService (CourseRepository courseRepository, OutboxEventRepository outboxRepo, ObjectMapper mapper) {
        this.courseRepository = courseRepository;
        this.outboxRepo = outboxRepo;
        this.mapper = mapper;
    }


    @Transactional
    public Course create(Course course) throws JsonProcessingException {

        Course savedCourse = courseRepository.save(course);
        OutboxEventJpaEntity event = new OutboxEventJpaEntity();
        event.setEventType("course.created");
        event.setEventData(mapper.writeValueAsString(savedCourse));
        outboxRepo.save(event);

        return savedCourse;
    }

    public Course getCourse(UUID id) {
        return null;
    }
}
