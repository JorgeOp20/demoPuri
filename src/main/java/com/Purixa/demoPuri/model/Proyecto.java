package com.Purixa.demoPuri.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long id;

    @Size(min = 2, max = 60)
    private String nombre;

    @DateTimeFormat
    //@NotNull
    @Column(name = "fechaDeCreacion")
    private LocalDate fechaCreacion;


    //@ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "proyecto")
    //@JoinColumn(name = "proyecto_id")
    private List<Tarea> tareas;



}
