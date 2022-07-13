package com.example.transporte.controller;

import com.example.transporte.models.entity.TipoProducto;
import com.example.transporte.models.services.ITipoProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TipoProductoControllerTest {

    @Mock
    private ITipoProductoService tipoProductoService;

    @InjectMocks
    private TipoProductoController tipoProductoController;

    private TipoProducto tipoProducto;
    private List<TipoProducto> tipoProductos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        tipoProducto = new TipoProducto();
        tipoProducto.setIdTipoProducto(1);
        tipoProducto.setNombre("ABC");
        tipoProductos = new ArrayList<>();
        tipoProductos.add(tipoProducto);
    }

    @Test
    void whenFindAllThenTListipoProductos() {
        Mockito.when(tipoProductoService.findAll()).thenReturn(tipoProductos);
        assertNotNull(tipoProductoController.tipoProductos());
    }

    @Test
    void givenTipoProductoWhenGuardarThenResponseOk() {
        Mockito.when(tipoProductoService.save(tipoProducto)).thenReturn(tipoProducto);
        assertEquals(tipoProductoController.guardar(tipoProducto), new ResponseEntity<String>("El tipo producto se guardo correctamente",
                HttpStatus.OK));
    }

    @Test
    void givenIdTipoProductoWhenEliminarThenVoid() {
        tipoProductoService.delete(ArgumentMatchers.anyInt());
        assertEquals(tipoProductoController.eliminar(ArgumentMatchers.anyInt()) , new ResponseEntity<String>("El tipo producto se elimino correctamente",
                HttpStatus.OK));
    }
}