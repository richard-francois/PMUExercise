package com.example.pmu.infrastructure.secondary.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
public class CourseJpaEntity {

    @Id
    private UUID id;
    private Date date;
    private Long numero;
    private String nom;
    private List<PartantJpaEntity> partants;
}
