package com.example.pmu.domain.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Partant {

    private UUID id;
    private Long numero;
    private String nom;
}
