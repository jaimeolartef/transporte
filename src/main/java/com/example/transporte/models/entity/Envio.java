package com.example.transporte.models.entity;

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
    @Column(name = "idEnvio", nullable = false)
    private Integer idEnvio;

    @Column(name = "numGuia", nullable = false)
    private String numGuia;

    @Column(name = "fechaRegistro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fechaEntrega", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "descuento")
    private Double descuento;

    @Column(name = "total")
    private Double total;

    @JoinColumn(name = "destino", referencedColumnName = "idDestino")
    @ManyToOne(fetch = FetchType.LAZY)
    private Destino destino;

    @JoinColumn(name = "vehiculo", referencedColumnName = "idVehiculo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehiculo vehiculo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "envio")
    private List<DetalleEnvio> detalleEnvios;
    
}
