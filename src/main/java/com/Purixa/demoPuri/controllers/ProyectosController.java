package com.Purixa.demoPuri.controllers;

import com.Purixa.demoPuri.model.Proyecto;
import com.Purixa.demoPuri.persistence.ProyectoJPARepository;
import com.Purixa.demoPuri.service.ProyectoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

@RestController
@RequestMapping("/proyectos")
@Validated
@Tag(name = "Demo Puri", description = "API final Demo Puri")
public class ProyectosController {
    @Autowired
    private ProyectoTareaService proyectoTareaService;
    @PostMapping(value="")
    public ResponseEntity<Proyecto> save (@RequestBody @Valid Proyecto proyecto) {
        return new ResponseEntity<>(proyectoTareaService.crearProyecto(proyecto), HttpStatus.CREATED);
    }
}
