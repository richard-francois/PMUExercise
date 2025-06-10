package com.example.pmu.infrastructure.secondary.persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "outbox")
@Data
public class OutboxEventJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String eventType;

    @Column(columnDefinition = "TEXT")
    private String eventData;

    private LocalDateTime createdAt = LocalDateTime.now();

    private boolean dispatched = false;
}
