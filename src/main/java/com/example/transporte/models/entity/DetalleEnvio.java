package com.example.transporte.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "detalleenvio")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleEnvio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleEnvio", nullable = false)
    private Integer idDetalleEnvio;

    @JoinColumn(name = "tipoProducto", referencedColumnName = "idTipoProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoProducto tipoProducto;

    @JoinColumn(name = "envio", referencedColumnName = "idEnvio")
    @ManyToOne(fetch = FetchType.LAZY)
    private Envio envio;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
}
