package com.example.pmu.infrastructure.primary.restapiadapter;

import com.example.pmu.application.service.CourseService;
import com.example.pmu.application.service.KafkaProducerService;
import com.example.pmu.domain.model.Course;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/course")
public class CourseController {

    KafkaProducerService kafkaProducerService;
    CourseService courseService;

    public CourseController(CourseService courseService, KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public ResponseEntity<Course> course(@RequestBody Course course) throws JsonProcessingException {
        UUID uuid = UUID.randomUUID();
        //log.info("We received the course definition, create with id: {}", uuid);
        //kafkaProducerService.send("course-topic", uuid, new CourseMessage()); //TODO: message to build not null
        return ResponseEntity.ok(courseService.create(course));
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable UUID id) {
        return courseService.getCourse(id);
    }
}
