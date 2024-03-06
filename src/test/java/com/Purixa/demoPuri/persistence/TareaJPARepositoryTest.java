package com.Purixa.demoPuri.persistence;

import com.Purixa.demoPuri.model.Proyecto;
import com.Purixa.demoPuri.model.Tarea;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.Purixa.demoPuri.persistence"})
@AutoConfigureTestEntityManager
class TareaJPARepositoryTest {
private static final Logger logger = LoggerFactory.getLogger(TareaJPARepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TareaJPARepository jpaRepo;

    @Test
    void save() {
        // given

        Proyecto aProyecto = entityManager.find(Proyecto.class, 1L);

        //Tarea nTarea = new Tarea(null, "Nueva tarea", LocalDate.of(2024,03,05), 6, false, null);
        Tarea nTarea = new Tarea(null, "nueva tarea", LocalDate.now(),3, false, aProyecto );
        nTarea.setId(null);
        // when
        jpaRepo.save(nTarea);
        System.out.println(nTarea);
        System.out.println("Tareas proyecto: " + aProyecto.getTareas());

        // then
        assertThat(nTarea.getId()).isGreaterThan(0);
    }

}