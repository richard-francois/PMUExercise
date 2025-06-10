package com.example.pmu.infrastructure.secondary.persistence;

import com.example.pmu.domain.model.Course;
import com.example.pmu.domain.port.CourseRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CoursePersistenceAdapter implements CourseRepository {

    private final CourseJpaRepository jpaRepository;
    private final CourseMapper courseMapper;

    public CoursePersistenceAdapter(CourseJpaRepository jpaRepository, CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Course save(Course course) {
        return courseMapper.toDto(jpaRepository.save(courseMapper.toEntity(course)));
    }

    @Override
    public Optional<Course> findById(UUID id) {
        return jpaRepository.findById(id).map(courseMapper::toDto);
    }

    @Override
    public List<Course> findAll() {
        return jpaRepository.findAll().stream().map(courseMapper::toDto).toList();
    }

}
