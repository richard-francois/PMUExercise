package com.example.pmu.application.service;

import com.example.pmu.domain.model.Course;
import com.example.pmu.domain.model.Partant;
import com.example.pmu.domain.port.CourseRepository;
import com.example.pmu.domain.port.PartantRepository;

import java.util.UUID;

public class PartantService {

    PartantRepository partantRepository;

    public PartantService (PartantRepository partantRepository) {
        this.partantRepository = partantRepository;
    }

    public Partant create(Course course, Partant partant) {
        return null;
    }

    public Partant get(UUID id) {
        return null;
    }
}
