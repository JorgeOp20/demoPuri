package com.Purixa.demoPuri.service;

import com.Purixa.demoPuri.exception.ProyectoNotfoundException;
import com.Purixa.demoPuri.exception.TareaNotfoundException;
import com.Purixa.demoPuri.model.Proyecto;
import com.Purixa.demoPuri.model.Tarea;
import com.Purixa.demoPuri.persistence.ProyectoJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProyectoTareaServiceC implements ProyectoTareaService{
    @Autowired
    private ProyectoJPARepository repo;
    @Override
    public Proyecto crearProyecto(Proyecto proyecto) throws RuntimeException {
        return repo.save(proyecto);
    }

    @Override
    public Proyecto anadeTareaAProyecto(Long idProyecto, Tarea tarea) throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public List<Proyecto> obtenerProyectos() throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public List<Tarea> obtenerTareasDelProyecto(Long idProyecto) throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public Tarea marcarTareaHecha(Long idTarea) throws TareaNotfoundException, RuntimeException {
        return null;
    }
}