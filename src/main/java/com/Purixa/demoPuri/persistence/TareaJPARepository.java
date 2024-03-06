package com.Purixa.demoPuri.persistence;


import com.Purixa.demoPuri.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaJPARepository extends JpaRepository<Tarea, Long> {

    public List<Tarea> findByProyecto_idOrderByOrdenAsc(Long idProyecto) throws RuntimeException;


    //public Tarea update(Tarea tarea) throws RuntimeException;
}
