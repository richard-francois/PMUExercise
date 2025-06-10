package com.example.pmu.infrastructure.primary.restapiadapter;

import com.example.pmu.infrastructure.secondary.persistence.CourseJpaEntity;
import com.example.pmu.infrastructure.secondary.persistence.CourseJpaRepository;
import com.example.pmu.infrastructure.secondary.persistence.PartantJpaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CourseJpaRepository repo;

    @Test
    void testListTasks() throws Exception {
        CourseJpaEntity course = CourseJpaEntity.builder().build();
        course.setId(UUID.randomUUID());
        course.setDate(LocalDate.now());
        course.setNumero(1L);
        course.setNom("test course");

        List<PartantJpaEntity> partants = new ArrayList<>();
        partants.add(PartantJpaEntity.builder().nom("mickey").numero(1L).build());
        partants.add(PartantJpaEntity.builder().nom("minnie").numero(2L).build());
        partants.add(PartantJpaEntity.builder().nom("donald").numero(3L).build());
        course.setPartants(partants);

        repo.save(course);

        mockMvc.perform(get("/course/create"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nom").value("test course"));
    }
}
