package com.example.pmu.application.service;

import com.example.pmu.domain.model.Course;
import com.example.pmu.domain.port.CourseRepository;
import com.example.pmu.infrastructure.secondary.persistence.OutboxEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CourseServiceTest {

    private final CourseRepository repo = mock(CourseRepository.class);
    private final OutboxEventRepository outboxRepo = mock();
    private final ObjectMapper mapper = mock();

    private final CourseService service = new CourseService(repo, outboxRepo, mapper);

    @Test
    void shouldCreateCourse() throws JsonProcessingException {
        when(repo.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
        Course course = service.create(Course.builder().nom("Test").build());

        assertEquals("Test", course.getNom());
        verify(repo).save(any());
    }

    @Test
    void shouldGetCourse() {
        UUID id = UUID.randomUUID();
        when(repo.findById(id)).thenReturn(Optional.of(Course.builder().nom("Test").id(id).build()));

        Course result = service.getCourse(id);
        assertEquals("Test", result.getNom());
    }
}