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
@Table(name = "vehiculo")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehiculo", nullable = false)
    private Integer idVehiculo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "identificacionvehiculo", nullable = false)
    private String identificacionVehiculo;

    @Column(name = "idtipovehiculo", nullable = false)
    private Integer idTipoVehiculo;

    @Transient
    private List<Envio> envios;
}
