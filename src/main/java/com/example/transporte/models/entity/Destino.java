package com.example.transporte.models.entity;

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
    @Column(name = "idDestino", nullable = false)
    private Integer idDestino;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino")
    private List<Envio> envios;

    @JoinColumn(name = "ciudad", referencedColumnName = "idCiudad")
    private Ciudad ciudad;

    @JoinColumn(name = "tipoDestino", referencedColumnName = "idTipoDestino")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoDestino tipoDestino;
    
}
