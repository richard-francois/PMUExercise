package com.example.pmu.domain.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class Course {

    private UUID id;
    private Date date;
    private Long numero;
    private String nom;
    private List<Partant> partants;
}
