package com.example.transporte.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "envio")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Envio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idenvio", nullable = false)
    private Integer idEnvio;

    @Column(name = "numguia", nullable = false)
    private String numGuia;

    @Column(name = "fecharegistro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fechaentrega", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "descuento")
    private Double descuento;

    @Column(name = "total")
    private Double total;

    @Column(name = "idcliente", nullable = false)
    private Integer idCliente;

    @Column(name = "iddestino", nullable = false)
    private Integer idDestino;

    @Column(name = "idvehiculo", nullable = false)
    private Integer idVehiculo;

    @Transient
    private Vehiculo vehiculo;

    @Transient
    private Cliente cliente;

    @Transient
    private Destino destino;

    @Transient
    private List<DetalleEnvio> detalleEnvios;
    
}
