package com.example.transporte.models.entity;

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
    @Basic(optional = false)
    @Column(name = "idDepartamento")
    private Integer idDepartamento;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private List<Ciudad> ciudades;

    @JoinColumn(name = "pais", referencedColumnName = "idPais")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pais pais;
    
}
