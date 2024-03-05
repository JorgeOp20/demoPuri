package com.Purixa.demoPuri.service;

import com.Purixa.demoPuri.model.Proyecto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.Purixa.demoPuri.service"})
@AutoConfigureTestEntityManager
class ProyectoTareaServiceCTest {
    @Autowired
    private ProyectoTareaService proyectoTareaService;
    @Test
    void crearProyecto() {
        Proyecto newProyecto = new Proyecto(null, "Nuevo proyecto", LocalDate.now(), null);
        proyectoTareaService.crearProyecto(newProyecto);
        System.out.println("newProyecto : " + newProyecto);
        assertThat(newProyecto.getId()).isGreaterThan(0);
    }
}