package com.example.transporte.controller;

import com.example.transporte.models.entity.DetalleEnvio;
import com.example.transporte.models.entity.TipoProducto;
import com.example.transporte.models.services.IDetalleEnvioService;
import com.example.transporte.models.services.ITipoProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;

class DetalleEnvioControllerTest {
    @Mock
    private IDetalleEnvioService detalleEnvioService;

    @Mock
    private ITipoProductoService tipoProductoService;

    @InjectMocks
    private DetalleEnvioController detalleEnvioController;

    private DetalleEnvio detalleEnvio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        detalleEnvio = new DetalleEnvio();
        detalleEnvio.setIdDetalleEnvio(1);
        detalleEnvio.setIdEnvio(1);
        detalleEnvio.setCantidad(1);
        detalleEnvio.setIdTipoProducto(1);
    }

    @Test
    void whenDetalleEnviosThenListDetalleEnvio() {
        Mockito.when(detalleEnvioService.findByIdEnvio(ArgumentMatchers.anyInt())).thenReturn(new ArrayList<>());
        Mockito.when(tipoProductoService.findByIdTipoProducto(ArgumentMatchers.anyInt())).thenReturn(Optional.of(new TipoProducto()));
        assertNotNull(detalleEnvioController.verDetalleEnvios(ArgumentMatchers.anyInt()));
    }

    @Test
    void givenListDetalleEnviowhenGuardarThenResponseHttpOk() {
        List<DetalleEnvio> detalleEnvios = new ArrayList<DetalleEnvio>();
        detalleEnvios.add(detalleEnvio);

        Mockito.when(detalleEnvioService.saveAll(anyList())).thenReturn(detalleEnvios);
        assertEquals(detalleEnvioController.guardarDetalleEnvio(detalleEnvios), new ResponseEntity<String>("El detalle del envio se guardo correctamente",
                HttpStatus.OK));
    }

    @Test
    void givenIdEnvioWhenEliminarThenVoid() {
        detalleEnvioService.delete(anyInt());
        assertEquals(detalleEnvioController.eliminar(anyInt()), new ResponseEntity<String>("El detalle envio se elimino correctamente",
                HttpStatus.OK));
    }
}