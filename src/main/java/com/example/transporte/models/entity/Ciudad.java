package com.example.transporte.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @Column(name = "idCiudad", nullable = false)
    private Integer idCiudad;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JoinColumn(name = "departamento", referencedColumnName = "idDepartamento")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento departamento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<Destino> destinos;
    
}
