package com.example.transporte.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    @Column(name = "iddetalleenvio", nullable = false)
    private Integer idDetalleEnvio;

    @Column(name = "idtipoproducto", nullable = false)
    private Integer idTipoProducto;

    @Column(name = "idenvio", nullable = false)
    private Integer idEnvio;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
}
