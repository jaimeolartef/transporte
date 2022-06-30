package com.example.transporte.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "departamento")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddepartamento", nullable = false)
    private Integer idDepartamento;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "idpais", nullable = false)
    private Integer idPais;

    @Transient
    private List<Ciudad> ciudades;
    
}
