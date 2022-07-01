package com.example.transporte.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente", nullable = false)
    private Integer idCliente;

    @Column(name = "numdocumento", nullable = false)
    private String numDocumento;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "idtipodocumento", nullable = false)
    private Integer idTipoDocumento;

    @Transient
    private TipoDocumento tipoDocumento;
}
