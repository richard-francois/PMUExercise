package com.example.pmu.infrastructure.secondary.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Builder
public class PartantJpaEntity {

    @Id
    private UUID id;
    private Long numero;
    private String nom;
}
