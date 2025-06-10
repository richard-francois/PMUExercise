package com.example.pmu.config;

import com.example.pmu.infrastructure.secondary.persistence.OutboxEventJpaEntity;
import com.example.pmu.infrastructure.secondary.persistence.OutboxEventRepository;
import jakarta.transaction.Transactional;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OutboxDispatcher {

    private final OutboxEventRepository repo;
    private final KafkaTemplate<String, String> kafka;

    public OutboxDispatcher(OutboxEventRepository repo, KafkaTemplate<String, String> kafka) {
        this.repo = repo;
        this.kafka = kafka;
    }

    @Scheduled(fixedRate = 5000)
    @Transactional
    public void dispatch() {
        List<OutboxEventJpaEntity> events = repo.findTop10ByDispatchedFalseOrderByCreatedAtAsc();
        for (OutboxEventJpaEntity e : events) {
            kafka.send(e.getEventType(), e.getEventData());
            e.setDispatched(true);
            repo.save(e);
        }
    }
}
