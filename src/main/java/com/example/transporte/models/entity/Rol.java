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
@Table(name = "authorities")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol", nullable = false)
	private Long idRol;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Transient
	private List<Usuario> usuarios;

}
