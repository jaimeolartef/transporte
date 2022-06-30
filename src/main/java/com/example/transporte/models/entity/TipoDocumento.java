package com.example.transporte.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipodocumento")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipodocumento", nullable = false)
    private Integer idTipoDocumento;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Transient
    private List<Cliente> clientes;
}
