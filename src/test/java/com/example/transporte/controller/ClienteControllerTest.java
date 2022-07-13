package com.example.transporte.controller;

import com.example.transporte.models.entity.Ciudad;
import com.example.transporte.models.entity.Cliente;
import com.example.transporte.models.entity.TipoDestino;
import com.example.transporte.models.entity.TipoDocumento;
import com.example.transporte.models.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class ClienteControllerTest {

    @Mock
    private IClienteService clienteService;

    @Mock
    private ITipoDocumentoService tipoDocumentoService;

    @InjectMocks
    private ClienteController clienteController;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setIdTipoDocumento(1);
        cliente.setDireccion("direccion test unit");
        cliente.setTelefono("12345678");
        cliente.setNombre("cliente test unit");
        cliente.setNumDocumento("1597536482");
    }

    @Test
    void whenFindAllClinetesThenListCliente() {
        when(clienteService.findAll()).thenReturn(Arrays.asList(cliente));
        when(tipoDocumentoService.findByIdTipoDocumento(anyInt())).thenReturn(new TipoDocumento());
        assertNotNull(clienteController.clientes());
    }

    @Test
    void givenClienteWhenGuardarThenResponseHttpOk() {
        when(clienteService.save(any(Cliente.class))).thenReturn(cliente);
        assertEquals(clienteController.guardar(cliente), new ResponseEntity<String>("El cliente se guardo correctamente",
                HttpStatus.OK));
    }

    @Test
    void givenIdClienteWhenEliminarThenVoid() {
        clienteService.delete(anyInt());
        assertEquals(clienteController.eliminar(anyInt()), new ResponseEntity<String>("El cliente se elimino correctamente",
                HttpStatus.OK));
    }
}