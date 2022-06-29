package com.example.transporte.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipoproducto")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoProducto", nullable = false)
    private Integer idTipoProducto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "envio")
    private List<DetalleEnvio> detalleEnvios;
}
