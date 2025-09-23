package output;

import Modelo.Persona;

public interface GuardarPersonaRepositorio {
    boolean guardar(Persona persona);

    boolean buscarPersona(String DNI);

}
