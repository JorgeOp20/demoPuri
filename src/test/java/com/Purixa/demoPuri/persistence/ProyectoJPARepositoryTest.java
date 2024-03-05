package com.Purixa.demoPuri.persistence;

import com.Purixa.demoPuri.model.Proyecto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.Purixa.demoPuri.persistence"})
@AutoConfigureTestEntityManager
class ProyectoJPARepositoryTest {
private static final Logger logger = LoggerFactory.getLogger(ProyectoJPARepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProyectoJPARepository jpaRepo;

    @Test
    void save() {
        // given
        Proyecto aProject = new Proyecto(null, "Another Fake Project", LocalDate.now(),null    );

        // when
        jpaRepo.save(aProject);

        System.out.println(aProject);

        // then
        assertThat(aProject.getId()).isGreaterThan(0);
    }

}