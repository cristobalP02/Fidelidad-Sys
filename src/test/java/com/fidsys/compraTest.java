package com.fidsys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class compraTest {
    private compra compra;

    @BeforeEach
    private void setUp() throws Exception{
        compra = new compra();
    }


    @Test
    public void testCrearCompra(){
        //Given
        int idCompra = 1;
        int idCliente = 999;
        Double monto = 999.9;
        LocalDate fecha = LocalDate.now();

        //When
        compra.setIdCliente(idCliente);
        compra.setIdCompra(idCompra);
        compra.setMonto(monto);
        compra.setFecha(fecha);

        //Then
        assertEquals(1, idCompra);
        assertEquals(999, idCliente);
        assertEquals(999.9, monto);
        assertEquals(LocalDate.now(), fecha);
    }
}