package com.example.transporte.models.entity;

import com.example.transporte.models.dao.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "clave", length = 60, nullable = false)
    private String clave;

    @Column(name = "habilitado")
    private boolean habilitado;

    @JoinColumn(name = "rol", referencedColumnName = "idRol")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rol rol;
}
