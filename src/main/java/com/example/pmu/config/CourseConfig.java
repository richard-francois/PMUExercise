package com.example.pmu.config;

import com.example.pmu.application.service.CourseService;
import com.example.pmu.domain.port.CourseRepository;
import org.springframework.context.annotation.Bean;

public class CourseConfig {

    @Bean
    public CourseService courseService(CourseRepository repository) {

        return new CourseService(repository);
    }
}
