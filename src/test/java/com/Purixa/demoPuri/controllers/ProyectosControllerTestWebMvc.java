package com.Purixa.demoPuri.controllers;

import com.Purixa.demoPuri.model.Proyecto;
import com.Purixa.demoPuri.persistence.ProyectoJPARepository;
import com.Purixa.demoPuri.service.ProyectoTareaService;
import com.Purixa.demoPuri.util.JsonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ProyectosControllerTestWebMvc {
    @Autowired
    private MockMvc mvc;
    //@MockBean
   // private ProyectosController proyectosController;
    @MockBean
    private ProyectoTareaService proyectoTareaService;
    @MockBean
    private ProyectoJPARepository proyectoJPARepository;

    /*
    @Test
    void givenProjecto_whenValidProjecto_thenIsCreatedAndHaveId() throws Exception {

        Proyecto newProyecto = new Proyecto(null, "Nuevo proyecto", LocalDate.now(), null);


        ResponseEntity<Proyecto> response = proyectosController.save(newProyecto);
        System.out.println("***** response:" + response);

        assertThat(response.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getBody().getId()).isGreaterThan(0);

    }*/

    @Test
    void givenProjecto_whenValidProjecto_thenResponseOK() throws Exception {

        Proyecto newProyecto = new Proyecto(null, "Nuevo proyecto", LocalDate.now(), null);
        Proyecto salidaProyecto = new Proyecto(1L, "Nuevo proyecto", LocalDate.now(), null);
        Mockito.when(proyectoTareaService.crearProyecto(Mockito.any())).thenReturn(salidaProyecto);

        mvc.perform(post("/proyectos")
                        .content(JsonUtil.asJsonString(newProyecto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id", is(greaterThanOrEqualTo(1))));

    }
    @Test
    void givenProjecto_whenInvalidProjecto_thenResponse400() throws Exception {

        Proyecto newProyecto = new Proyecto(null, "N", LocalDate.now(), null);
        //Mockito.when(proyectoTareaService.crearProyecto(newProyecto)).thenThrow(ConstraintViolationException.class);

        mvc.perform(post("/proyectos")
                        .content(JsonUtil.asJsonString(newProyecto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}