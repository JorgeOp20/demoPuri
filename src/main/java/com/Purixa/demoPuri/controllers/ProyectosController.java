package com.Purixa.demoPuri.controllers;

import com.Purixa.demoPuri.model.Proyecto;
import com.Purixa.demoPuri.model.Tarea;
import com.Purixa.demoPuri.persistence.ProyectoJPARepository;
import com.Purixa.demoPuri.service.ProyectoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

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
    @PostMapping(value="/anadirTarea/{pid}")
    public ResponseEntity<Proyecto> anadirTarea (@PathVariable @Min(1) Long pid, @RequestBody @Valid Tarea tarea) {
        return new ResponseEntity<>(proyectoTareaService.anadeTareaAProyecto(pid, tarea), HttpStatus.CREATED);
    }
    @GetMapping(value="/{pid}/tareas")
    public ResponseEntity listarTareas (@PathVariable @Min(1) Long pid) {

        List<Tarea> accs = proyectoTareaService.obtenerTareasDelProyecto(pid);
        if (accs != null && accs.size() > 0) return ResponseEntity.status(HttpStatus.OK).body(accs);
        else return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
