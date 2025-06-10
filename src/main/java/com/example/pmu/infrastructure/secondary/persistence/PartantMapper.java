package com.example.pmu.infrastructure.secondary.persistence;

import com.example.pmu.domain.model.Partant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PartantMapper {
    Partant toDto (PartantJpaEntity source);
    PartantJpaEntity toEntity (Partant source);
}
