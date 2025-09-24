package useCase;

import Modelo.Persona;
import Modelo.PersonaException;
import Modelo.PersonaExisteException;
import Modelo.RepositorioException;
import input.CrearPersonaInput;
import output.GuardarPersonaRepositorio;

import java.time.LocalDate;

public class CrearPersonaUseCase implements CrearPersonaInput {

    private final GuardarPersonaRepositorio guardarPersonaRepositorio;

    public CrearPersonaUseCase(GuardarPersonaRepositorio guardarPersonaRepositorio) {

        this.guardarPersonaRepositorio = guardarPersonaRepositorio;
    }

    @Override
    public boolean create(String nombre, String apellido, String DNI, LocalDate fechaNacimiento, double altura, int peso) {
       //el Persona.create llama al constructor privado y valida las excepciones y ese create es el de la clase persona
        Persona persona=Persona.create(nombre, apellido, DNI, fechaNacimiento, altura, peso);

       if(this.guardarPersonaRepositorio.buscarPersona(DNI)){
           throw new PersonaExisteException("Persona ya existe");

       }

         if(!this.guardarPersonaRepositorio.guardar(persona)){

              throw new RepositorioException("algo salio mal");
         }

         return true;
    }


}
