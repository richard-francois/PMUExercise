package com.example.pmu.config;

import com.example.pmu.application.service.CourseService;
import com.example.pmu.domain.port.CourseRepository;
import com.example.pmu.infrastructure.secondary.persistence.OutboxEventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

public class CourseConfig {

    @Bean
    public CourseService courseService(
            CourseRepository repository,
            OutboxEventRepository outboxEventRepository,
            ObjectMapper mapper
    ) {

        return new CourseService(repository, outboxEventRepository, mapper);
    }
}
