package com.example.transporte.controller;

import com.example.transporte.models.entity.Cliente;
import com.example.transporte.models.entity.Destino;
import com.example.transporte.models.entity.Envio;
import com.example.transporte.models.entity.Vehiculo;
import com.example.transporte.models.services.IClienteService;
import com.example.transporte.models.services.IDestinoService;
import com.example.transporte.models.services.IEnvioService;
import com.example.transporte.models.services.IVehiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnvioControllerTest {

    @Mock
    private IEnvioService envioService;

    @Mock
    private IDestinoService destinoService;

    @Mock
    private IVehiculoService vehiculoService;

    @Mock
    private IClienteService clienteService;

    @InjectMocks
    private EnvioController envioController;

    private Envio envio;

    private List<Envio> envios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        envio = new Envio();
        envio.setIdEnvio(1);
        envio.setNumGuia("ABC");
        envio.setFechaEntrega(new Date());
        envio.setFechaEntrega(new Date());
        envio.setSubtotal(0D);
        envio.setDescuento(0D);
        envio.setTotal(0D);
        envio.setIdCliente(1);
        envio.setIdDestino(1);
        envio.setIdVehiculo(1);

        envios = new ArrayList<>();
        envios.add(envio);
    }

    @Test
    void whenFindAllEnviosThenListEnvio() {
        Mockito.when(envioService.findAll()).thenReturn(envios);
        Mockito.when(destinoService.findByIdDestino(ArgumentMatchers.anyInt())).thenReturn(new Destino());
        Mockito.when(clienteService.findByIdCliente(envio.getIdCliente())).thenReturn(new Cliente());
        Mockito.when(vehiculoService.findById(envio.getIdVehiculo())).thenReturn(new Vehiculo());
        assertNotNull(envioController.envios());
    }

    @Test
    void givenEnvioWhenGuardarThenEnvio() {
        Mockito.when(envioService.save(envio)).thenReturn(envio);
        assertEquals(envioController.guardar(envio), new ResponseEntity<String>("El envio se guardo correctamente",
                HttpStatus.OK));
    }

    @Test
    void givenIdEnvioWhenEliminarThenVoid() {
        envioService.delete(ArgumentMatchers.anyInt());
        assertEquals(envioController.eliminar(ArgumentMatchers.anyInt()), new ResponseEntity<String>("El detalle envio se elimino correctamente",
                HttpStatus.OK));
    }
}