package Modelo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    public void IntanciarPersona_AtributosNoNulo(){

        Persona nuevaPersona=Persona.create("Agustin","Gomez","43611353",21,1.70,100);

        Assertions.assertNotNull(nuevaPersona);
        Assertions.assertEquals("Gomez",nuevaPersona.getApellido());
    }

    @Test
    public void create_nombreVacioONulo_execption(){

        PersonaExceptionNombre exception=Assertions.assertThrows(PersonaExceptionNombre.class, ()->Persona.create(" ","Gomez","43611353",21,1.70,90));
        Assertions.assertEquals("El nombre no puede ser nulo ni vacio", exception.getMessage());

    }
    @Test
    public void create_EdadIncorrecta(){


        PersonaExceptionEdad exception=Assertions.assertThrows(PersonaExceptionEdad.class, ()->Persona.create("Agustin","Gomez","43611353",91,1.40,93));


        Assertions.assertEquals("La edad es invalida", exception.getMessage());

    }



}
