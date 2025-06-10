package com.example.pmu.infrastructure.secondary.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
public class CourseJpaEntity {

    @Id
    private UUID id;
    private LocalDate date;
    private Long numero;
    private String nom;
    private List<PartantJpaEntity> partants;
}
