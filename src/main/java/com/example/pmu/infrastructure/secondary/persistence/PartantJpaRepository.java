package com.example.pmu.infrastructure.secondary.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartantJpaRepository extends JpaRepository<PartantJpaEntity, UUID> { }
