package com.example.transporte.controller;

import com.example.transporte.models.entity.TipoDestino;
import com.example.transporte.models.services.ITipoDestinoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TipoDestinoControllerTest {

    @Mock
    private ITipoDestinoService tipoDestinoService;

    @InjectMocks
    private  TipoDestinoController tipoDestinoController;

    private TipoDestino tipoDestino;
    private List<TipoDestino> tipoDestinos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tipoDestino = new TipoDestino();
        tipoDestino.setIdTipoDestino(1);
        tipoDestino.setNombre("Nombre");

        tipoDestinos = new ArrayList<>();
        tipoDestinos.add(tipoDestino);
    }

    @Test
    void whenFindAllTipoDestinoThenListTipoDestino() {
        Mockito.when(tipoDestinoService.findAll()).thenReturn(tipoDestinos);
        assertNotNull(tipoDestinoController.tipoDestinos());
    }
}