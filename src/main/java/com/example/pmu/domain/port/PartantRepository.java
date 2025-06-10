package com.example.pmu.domain.port;

import com.example.pmu.domain.model.Partant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartantRepository {
    Partant save(Partant partant);
    Optional<Partant> findById(UUID id);
    List<Partant> findAll();
}