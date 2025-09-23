package input;

import java.time.LocalDate;

public interface CrearPersonaInput {
    boolean create(String nombre, String apellido, String DNI, LocalDate fechaNacimiento,double altura,int peso);


}
