package com.Purixa.demoPuri.service;


import com.Purixa.demoPuri.exception.ProyectoNotfoundException;
import com.Purixa.demoPuri.exception.TareaNotfoundException;
import com.Purixa.demoPuri.model.Proyecto;
import com.Purixa.demoPuri.model.Tarea;

import java.util.List;

public interface ProyectoTareaService {

    public Proyecto crearProyecto(Proyecto proyecto) throws RuntimeException;

    public Proyecto anadeTareaAProyecto(Long idProyecto, Tarea tarea) throws ProyectoNotfoundException, RuntimeException;

    public List<Proyecto> obtenerProyectos() throws ProyectoNotfoundException, RuntimeException;

    public List<Tarea> obtenerTareasDelProyecto(Long idProyecto) throws ProyectoNotfoundException, RuntimeException;

    public Tarea marcarTareaHecha(Long idTarea) throws TareaNotfoundException, RuntimeException;

}
