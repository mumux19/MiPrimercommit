package Modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    public void IntanciarPersona_AtributosNoNulo{

    Persona nuevaPersona= Persona.create("Agustin","Gomez","43611353",21,1.70,100);

        Assertions.assertNotNull(nuevaPersona);
        Assertions.assertEquals("Gomez",nuevaPersona.getApellido());
    }

}
