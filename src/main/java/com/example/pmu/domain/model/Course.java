package com.example.pmu.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Course {

    private UUID id;
    private LocalDate date;
    private Long numero;
    private String nom;
    private List<Partant> partants;
}
