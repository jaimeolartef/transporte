package com.example.transporte.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ciudad")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idciudad", nullable = false)
    private Integer idCiudad;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "iddepartamento", nullable = false)
    private Integer idDepartamento;
    
}
