package com.example.transporte.models.dao;

import com.example.transporte.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {

    public Usuario findByNombre(String nombre);
}
