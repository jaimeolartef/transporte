package com.example.transporte.controller;

import com.example.transporte.models.entity.Ciudad;
import com.example.transporte.models.services.ICiudadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CiudadControllerTest {

    @Mock
    private ICiudadService ciudadService;

    @InjectMocks
    private CiudadController ciudadController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenFindAllCiudadesThenListCiudad() {
        Mockito.when(ciudadService.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(ciudadController.ciudades());
    }
}