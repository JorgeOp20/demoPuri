package com.Purixa.demoPuri.persistence;


import com.Purixa.demoPuri.model.Tarea;

import java.util.List;

public interface TareaJPARepository {

    public List<Tarea> findByProject(Long idProyecto) throws RuntimeException;


    public Tarea update(Tarea tarea) throws RuntimeException;
}
