package com.example.pmu.infrastructure.secondary.persistence;

import com.example.pmu.domain.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {
    Course toDto (CourseJpaEntity source);
    CourseJpaEntity toEntity (Course source);
}
