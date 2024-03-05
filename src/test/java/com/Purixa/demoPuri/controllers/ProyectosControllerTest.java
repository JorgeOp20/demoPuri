package com.Purixa.demoPuri.controllers;

import com.Purixa.demoPuri.model.Proyecto;
import com.Purixa.demoPuri.persistence.ProyectoJPARepository;
import com.Purixa.demoPuri.util.JsonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ProyectosControllerTest {
    @Autowired
    private MockMvc mvc;

    //@MockBean
    //private ProductsService service;

    //@MockBean
    //private ProyectoJPARepository repository;
    @Autowired
    private ProyectosController proyectosController;


    @Test
    void givenProjecto_whenValidProjecto_thenIsCreatedAndHaveId() throws Exception {

        Proyecto newProyecto = new Proyecto(null, "Nuevo proyecto", LocalDate.now(), null);


        ResponseEntity<Proyecto> response = proyectosController.save(newProyecto);
        System.out.println("***** response:" + response);

        assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getBody().getId()).isGreaterThan(0);

    }

    @Test
    void givenProjecto_whenInvalidProjecto_thenResponseNOK() throws Exception {

        Proyecto newProyecto = new Proyecto(null, "N", LocalDate.now(), null);


        Assertions.assertThrows(RuntimeException.class, () -> {
            ResponseEntity<Proyecto> response = proyectosController.save(newProyecto);

        });
    }


}