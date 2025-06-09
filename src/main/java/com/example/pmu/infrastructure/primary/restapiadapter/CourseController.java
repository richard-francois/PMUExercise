package com.example.pmu.infrastructure.primary.restapiadapter;

import com.example.pmu.application.service.CourseService;
import com.example.pmu.application.service.KafkaProducerService;
import com.example.pmu.domain.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/course")
public class CourseController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @Autowired
    CourseService courseService;

    @PostMapping("/create")
    ResponseEntity<Course> course(@RequestBody Course course) {
        UUID uuid = UUID.randomUUID();
        //log.info("We received the course definition, create with id: {}", uuid);
        //kafkaProducerService.send("course-topic", uuid, new CourseMessage()); //TODO: message to build not null
        return ResponseEntity.ok(courseService.create());
    }
}
