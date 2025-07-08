package com.fidsys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class clienteTest{

    private cliente cliente;

    @BeforeEach
    private void setUp() throws Exception{
        cliente = new cliente();
    }

    @Test
    public void crear_Cliente() throws Exception{
        //Given
        int id = 9999;
        String nombre = "Cristobal Perez";
        String correo = "cristobal.perezb@usm.cl";


        //When
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");

        //Then
        assertEquals(id, cliente.getId());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(correo, cliente.getCorreo());
        assertEquals(0, cliente.getPuntos());
        assertEquals("Bronce", cliente.getNivel());
    }

    @Test
    public void correoErroneo() throws Exception{
        //Given
        String correo = "cristobal.gmail.cl";

        //When
        cliente.setCorreo(correo);

        //Then
        assertEquals(null, cliente.getCorreo(), "El resultado ha sido erroneo, ha asignado el correo, pese a que no tiene @");
    }


    @Test
    public void subirNivelPlata1() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(500);

        //Then
        assertEquals("Plata", cliente.getNivel(), "No subio de nivel a Plata, pero debería");
    }

    @Test
    public void subirNivelPlata2() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(200);
        cliente.addPuntos(350);

        //Then
        assertEquals("Plata", cliente.getNivel(), "No subio de nivel a Plata, pero debería");
    }

    @Test
    public void noSubirNivelPlata() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(499);

        //Then
        assertNotEquals("Plata", cliente.getNivel(), "Subio de nivel a Plata, pero no debería");
    }


    @Test
    public void subirNivelOro1() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(1500);

        //Then
        assertEquals("Oro", cliente.getNivel(), "No subio de nivel a Oro, pero debería");
    }

    @Test
    public void subirNivelOro2() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(300);
        cliente.addPuntos(479);
        cliente.addPuntos(1112);

        //Then
        assertEquals("Oro", cliente.getNivel(), "No subio de nivel a Oro, pero debería");
    }

    @Test
    public void noSubirNivelOro() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(1499);

        //Then
        assertNotEquals("Oro", cliente.getNivel(), "Subio de nivel a Oro, pero no debería");
    }


    public void subirNivelPlatino1() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(3000);

        //Then
        assertEquals("Oro", cliente.getNivel(), "No subio de nivel a Oro, pero debería");
    }

    @Test
    public void subirNivelPlatino2() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(132);
        cliente.addPuntos(1921);
        cliente.addPuntos(500);
        cliente.addPuntos(999);

        //Then
        assertEquals("Platino", cliente.getNivel(), "No subio de nivel a Platino, pero debería");
    }

    @Test
    public void noSubirNivelPlatino() throws Exception{
        //Given
        cliente.setPuntos(0);
        cliente.setNivel("Bronce");
        
        //When
        cliente.addPuntos(2999);

        //Then
        assertNotEquals("Platino", cliente.getNivel(), "Subio de nivel a Oro, pero no debería");
    }

    /*
     * @Test
    public void correoErroneo(){
        //Given
        //When
        //Then
    }

    
     */
}