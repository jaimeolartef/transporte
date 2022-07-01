package com.example.transporte.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "destino")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Destino implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddestino", nullable = false)
    private Integer idDestino;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "idciudad", nullable = false)
    private Integer idCiudad;

    @Column(name = "idtipodestino", nullable = false)
    private Integer idTipoDestino;

    @Transient
    private List<Envio> envios;

    @Transient
    private Ciudad ciudad;

    @Transient
    private TipoDestino tipoDestino;

    @Transient
    private List<TipoDestino> tipoDestinos;

    @Transient
    private List<Ciudad> ciudades;
    
}
