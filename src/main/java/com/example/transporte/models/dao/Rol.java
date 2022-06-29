package com.example.transporte.models.dao;

import com.example.transporte.models.entity.Envio;
import com.example.transporte.models.entity.Usuario;
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
	private Long idRol;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
	private List<Usuario> usuarios;

}
