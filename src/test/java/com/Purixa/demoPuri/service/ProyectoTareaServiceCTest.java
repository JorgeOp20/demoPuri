package com.Purixa.demoPuri.service;

import com.Purixa.demoPuri.exception.ProyectoNotfoundException;
import com.Purixa.demoPuri.model.Proyecto;
import com.Purixa.demoPuri.model.Tarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.Purixa.demoPuri.service"})
@AutoConfigureTestEntityManager
class ProyectoTareaServiceCTest {
    @Autowired
    private ProyectoTareaService proyectoTareaService;
    @Autowired
    private EntityManager entityManager;
    @Test
    void crearProyecto() {
        Proyecto newProyecto = new Proyecto(null, "Nuevo proyecto", LocalDate.now(), null);
        proyectoTareaService.crearProyecto(newProyecto);
        System.out.println("newProyecto : " + newProyecto);
        assertThat(newProyecto.getId()).isGreaterThan(0);
    }
    @Test
    void anadeTareaAProyecto () {
        Tarea tarea = new Tarea(null, "nueva tarea", LocalDate.now(), 4, false, null);
        Proyecto aProyecto =  entityManager.find(Proyecto.class, 1L);

        Proyecto nProyecto =  proyectoTareaService.anadeTareaAProyecto(1L, tarea);
        assertThat(nProyecto.getTareas().size() == aProyecto.getTareas().size() + 1);
    }
    @Test
    void anadeTareaAProyecto_cuandoProyectoInexistente_KO () {
        Tarea tarea = new Tarea(null, "nueva tarea", LocalDate.now(), 4, false, null);

         assertThrows(ProyectoNotfoundException.class, () -> {
            proyectoTareaService.anadeTareaAProyecto(5L, tarea);
        });
    }
    @Test
    void anadeTareaAProyecto_cuandoTareaIncorrecta_KO () {


         assertThrows(Exception.class, () -> {
            Tarea tarea = new Tarea(null, "n", LocalDate.now(), 4, false, null);
            proyectoTareaService.anadeTareaAProyecto(5L, tarea);
        });
    }
    @Test
    void listaTareasProyecto () {

        Proyecto aProyecto =  entityManager.find(Proyecto.class, 2L);

        List<Tarea> lista =  proyectoTareaService.obtenerTareasDelProyecto(2L);
        assertThat(lista.size()>0);
        assertThat(lista.contains(aProyecto));
    }
    @Test
    void listaTareas_cuandoInexistenteProyecto_KO () {


         assertThrows(ProyectoNotfoundException.class, () -> {
            proyectoTareaService.obtenerTareasDelProyecto(5L);
        });
    }
}