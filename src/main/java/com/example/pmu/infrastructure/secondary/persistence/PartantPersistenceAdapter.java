
package com.example.pmu.infrastructure.secondary.persistence;

import com.example.pmu.domain.model.Partant;
import com.example.pmu.domain.port.PartantRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PartantPersistenceAdapter implements PartantRepository {

    private final PartantJpaRepository jpaRepository;
    private final PartantMapper partantMapper;

    public PartantPersistenceAdapter(PartantJpaRepository jpaRepository, PartantMapper partantMapper) {
        this.partantMapper = partantMapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Partant save(Partant partant) {
        return partantMapper.toDto(jpaRepository.save(partantMapper.toEntity(partant)));
    }

    @Override
    public Optional<Partant> findById(UUID id) {
        return jpaRepository.findById(id).map(partantMapper::toDto);
    }

    @Override
    public List<Partant> findAll() {
        return jpaRepository.findAll().stream().map(partantMapper::toDto).toList();
    }

}
