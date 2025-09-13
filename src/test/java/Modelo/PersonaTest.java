package Modelo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    public void IntanciarPersona_AtributosNoNulo(){

        Persona nuevaPersona= Persona.create("Agustin","Gomez","43611353",21,1.70,100);

        Assertions.assertNotNull(nuevaPersona);
        Assertions.assertEquals("Gomez",nuevaPersona.getApellido());
    }

    @Test
    public void create_nombreVacioONulo_execption(){

        Assertions.assertThrows(PersonaExceptionNombre.class, ()->Persona.create(" ","Gomez","43611353",21,1.70,90));


    }
    @Test
    public void create_EdadIncorrecta(){


        Assertions.assertThrows(PersonaExceptionEdad.class, ()->Persona.create("Agustin","Gomez","43611353",91,1.40,93));

    }



}
