package useCase;

import Modelo.Persona;
import Modelo.PersonaExisteException;
import Modelo.RepositorioException;
import input.CrearPersonaInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.GuardarPersonaRepositorio;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class CrearPersonaUseCaseTest {

    @Mock
    GuardarPersonaRepositorio repositorio;

    @Test
    public void CrearPersona_Sucess(){

        CrearPersonaInput useCase=new CrearPersonaUseCase(repositorio);

        when(repositorio.buscarPersona("43611353")).thenReturn(false);
        when(repositorio.guardar(any(Persona.class))).thenReturn(true);

        boolean resultado= useCase.create("agustin","gomez","43611353", LocalDate.of(2002,6,2),1.60,90);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void CrearPersona_PersonaDuplicada(){

        CrearPersonaInput useCase=new CrearPersonaUseCase((repositorio));
        when(repositorio.buscarPersona("43611353")).thenReturn(true);

        Assertions.assertThrows(PersonaExisteException.class,()->useCase.create("agustin","gomez","43611353", LocalDate.of(2002,6,2),1.60,90)) ;

        verify(repositorio,never()).guardar(any());


    }

    @Test
    public void CrearPersona_AtributosInvalidos_Error(){
        CrearPersonaInput useCase=new CrearPersonaUseCase(repositorio);

        verify(repositorio,never()).buscarPersona(any());
        verify(repositorio,never()).guardar(any());


        Assertions.assertThrows(RuntimeException.class,()->useCase.create("","gomez","43611353", LocalDate.of(2002,6,2),1.60,90)) ;

    }

    @Test
    public void CrearPersona_RepositorioFalla_Error(){
        CrearPersonaInput useCase=new CrearPersonaUseCase(repositorio);

        //hago que falle el repositorio
        when(repositorio.buscarPersona("43611353")).thenReturn(false);
        when(repositorio.guardar(any(Persona.class))).thenReturn(false);

        Assertions.assertThrows(RepositorioException.class, ()-> useCase.create("agustin","gomez","43611353", LocalDate.of(2002,6,2),1.60,90));

    }

}
