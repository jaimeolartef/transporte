package com.example.transporte.models.dao;

import com.example.transporte.models.entity.Ciudad;
import org.springframework.data.repository.CrudRepository;

public interface ICiudadDao extends CrudRepository<Ciudad, Integer> {
}
