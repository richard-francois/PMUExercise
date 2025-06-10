package com.example.pmu.config;

import com.example.pmu.application.service.CourseService;
import com.example.pmu.application.service.PartantService;
import com.example.pmu.domain.port.CourseRepository;
import com.example.pmu.domain.port.PartantRepository;
import org.springframework.context.annotation.Bean;

public class PartantConfig {
    @Bean
    public PartantService courseService(PartantRepository repository) {

        return new PartantService(repository);
    }
}
