package com.Purixa.demoPuri.persistence;



import com.Purixa.demoPuri.model.Proyecto;

import java.util.List;

public interface ProyectoJPARepository {

    public List<Proyecto> findAll() throws RuntimeException;

    public Proyecto save(Proyecto proyecto) throws RuntimeException;

    public Proyecto update(Proyecto proyecto) throws RuntimeException;

}
