package com.example.pmu.infrastructure.secondary.persistence;

import com.example.pmu.domain.model.Partant;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class CourseEntity {

    @Id
    private UUID id;
    private Date date;
    private Long numero;
    private String nom;
    private List<PartantEntity> partants;
}
